package com.venky.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venky.entity.UserDetails;
import com.venky.service.UserService;

@RestController
public class RegisterController {
	
	@Autowired
	UserService uService;
	
	@RequestMapping(value="/loadUserRegister",method=RequestMethod.GET)
	public ResponseEntity<Object> loadRegister()
	{
		UserDetails udetails=new UserDetails();
		
		return new ResponseEntity<Object>(udetails,HttpStatus.OK);
	}
	/*
	@GetMapping("/countryList")
	public String getCountries(Model model)
	{
		Map<Integer, String> countries = uService.findCountries();
		model.addAttribute("listCountries", countries);
		return "redirect:/register";
	}
	
	@GetMapping("/stateList")
	public String getStates(@RequestParam("cid") Integer cid,Model model)
	{
		Map<Integer, String> states = uService.findStates(cid);
		model.addAttribute("listStates",states);
		return "redirect:/register";	
	}
	
	@GetMapping("/citiesList")
	public String getCities(@RequestParam("sid") Integer sid,Model model)
	{
		Map<Integer, String> cities = uService.findCities(sid);
		model.addAttribute("listCities", cities);
		return "redirect:/register";
	}
	
	@GetMapping("/emailIdUnique")
	public String getEmailUnique(@RequestParam("emailId") String emailId,Model model)
	{
		boolean unique = uService.isEmailUnique(emailId);
		model.addAttribute("isUnique",unique);
		return "redirect:/register";
	}
	*/
	@RequestMapping(value="/userRegister",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity<Object> userRegister(@RequestParam("cid") Integer cid,@RequestParam("sid") Integer sid,
			@RequestParam("emailId") String emailId,Model model,UserDetails udetails)
	{
		Map<Integer, String> countries = uService.findCountries();
		model.addAttribute("listCountries", countries);
		
		Map<Integer, String> states = uService.findStates(cid);
		model.addAttribute("listStates",states);
		
		Map<Integer, String> cities = uService.findCities(sid);
		model.addAttribute("listCities", cities);
		
		boolean unique = uService.isEmailUnique(emailId);
		model.addAttribute("isUnique",unique);
		
		boolean UserRegister = uService.saveUser(udetails);
		model.addAttribute("isBoolean", UserRegister);
		
		return new ResponseEntity<Object>(UserRegister,HttpStatus.OK);
	}
}
