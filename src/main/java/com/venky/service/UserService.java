package com.venky.service;

import java.util.Map;

import com.venky.entity.UserDetails;

public interface UserService {
	
//User registration
	public Map<Integer,String> findCountries();
	
	public Map<Integer,String> findStates(Integer cId);
	
	public Map<Integer,String> findCities(Integer sId);
	
	public boolean isEmailUnique(String emailId);
	
	public boolean saveUser(UserDetails ud);
	
//login page
	//return as string,it will check credentials are valid and find account is locked or not
	public String userLogin(String emailId,String password);
	
	//unlocking account
	public boolean checkUserTempPwd(String emailId,String tempPwd);
	
	public boolean UnlockUserAccount(String emailId,String password);
	
	//forgot password
	public String forgotPassword(String emailId);
}
