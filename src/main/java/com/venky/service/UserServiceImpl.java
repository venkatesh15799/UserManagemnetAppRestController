package com.venky.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venky.entity.City;
import com.venky.entity.Country;
import com.venky.entity.State;
import com.venky.entity.UserDetails;
import com.venky.repository.CityRepository;
import com.venky.repository.CountryRepository;
import com.venky.repository.StateRepository;
import com.venky.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	CountryRepository countryRepo; 
	
	@Autowired
	StateRepository stateRepo;
	
	@Autowired
	CityRepository cityRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserDetails userDetails;
	
	@Override
	public Map<Integer, String> findCountries() {
		List<Country> countryList = countryRepo.findCountries();
		Map<Integer,String> countries=new HashMap<>();
		countryList.forEach(country ->{
		countries.put(country.getCid(),country.getCountryName());
		});
		return countries;
	}

	@Override
	public Map<Integer, String> findStates(Integer cId) {
		List<State> stateList = stateRepo.findStates(cId);
		Map<Integer,String> states=new HashMap<>();
		stateList.forEach(state ->{
			states.put(state.getSid(), state.getStateName());
		});
		return states;
	}
	@Override
	public Map<Integer, String> findCities(Integer sId) {
		
		List<City> cityList = cityRepo.findCities(sId);
		Map<Integer,String> cities=new HashMap<>();
		cityList.forEach(city ->{
			cities.put(city.getcId(), city.getCityName());
		});
		return cities;
	}

	//test case : 1 ->To check given mailId is already exist or not
	//test case : 2 ->email_id in UserDetails object to check that email id 
	//                unique(find to get userId == null then it is true when you register,email id contain user id 
	@Override
	public boolean isEmailUnique(String emailId) {
		
		 UserDetails details = userRepo.findByEmailIdIgnoreCase(emailId);
		 return details.getUid()==null;
		
		 /*
		UserDetails details = userRepo.findByEmailIdIgnoreCase(userDetails.getEmailId());	
		return details!=null;
		*/
	}
	//after user successful register,user should get temp pwd,hear we need to generate random pwd
	@Override
	public boolean saveUser(UserDetails ud) {
		ud.setPassword(passwordGenerator());
		UserDetails uDetails = userRepo.save(ud);
		return uDetails.getUid()!=null;
	}

	private  String passwordGenerator()
	{
		char[] password=new char[8];
		String pwd="ABCDEFGHIJKLabcdefghij1234566790";
		Random rd=new Random();
		for(int i=0;i<8;i++)
		{
			password[i]=pwd.charAt(rd.nextInt(pwd.length()));
		}
		System.out.println(password.toString());
		return password.toString();
	}
	// test case:1-> to check credentials are valid or invalid
	// test case:2-> to check account is locked or not
	@Override
	public String userLogin(String emailId, String password) {
		
		 UserDetails userDetails = userRepo.findUserLogin(emailId, password);
		if(userDetails != null)
		{
			if(userDetails.getAccountStatus().equals("LOCKED")){
				return "User Locked State";
			}else {
			   return "Login success";
		    }
		}
		return "invalid credentials";	
	}
	//test case:1-> mail-id,tempPwd valid details or not based on userId
	@Override
	public boolean checkUserTempPwd(String emailId, String tempPwd) {

		UserDetails uDetails = userRepo.findByEmailIdIgnoreCase(emailId,tempPwd);
		return uDetails.getUid()!=null;
	}
	//test case:1->valid email id or not
	@Override
	public boolean UnlockUserAccount(String emailId, String newPwd) {

		UserDetails details = userRepo.findByEmailIdIgnoreCase(emailId);
		details.setPassword(newPwd);
		details.setAccountStatus("UNLOCKED");
		try
		{
			userRepo.save(details);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
			
	}
	//test case:1->Given user mail id valid or not,if valid existing password to user
	//test case:2->if in-valid return null
	@Override
	public String forgotPassword(String emailId) {
		UserDetails details = userRepo.findByEmailIdIgnoreCase(emailId);
		if(details.getUid()!=null)
		{
			 return details.getPassword();
		}
		return null;
	}

}
