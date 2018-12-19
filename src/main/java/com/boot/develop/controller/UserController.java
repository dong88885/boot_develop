package com.boot.develop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.develop.DataValidException;
import com.boot.develop.entity.User;
import com.boot.develop.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	public ResponseEntity<User> addUser(@Valid @RequestBody User user,Errors errors) {
		
		
		if(errors.hasErrors())
			throw new DataValidException(HttpStatus.BAD_REQUEST,errors);
		
		if(userService.addUser(user)>0);
		
		return userService.addUser(user)>0 ? ResponseEntity.status(HttpStatus.CREATED).body(user) :ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

}
