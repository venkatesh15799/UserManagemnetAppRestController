package com.venky.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venky.entity.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Serializable> {
	
	UserDetails findByEmailIdIgnoreCase(String emailId);
	UserDetails findByEmailIdIgnoreCase(String emailId,String tempPwd);
	UserDetails findUserLogin(String emailId,String password);
	
}
