package com.venky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venky.service.UserService;

@RestController
public class UnlockController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/userUnLock",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> userUnlock(@RequestParam("emailId") String emailId,@RequestParam("Password") String password)
	{
	 boolean UnlockUserAccount = userService.UnlockUserAccount(emailId, password);
	 return new ResponseEntity<Object>(UnlockUserAccount,HttpStatus.OK);
	}
}
