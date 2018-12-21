package com.boot.develop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.develop.entity.User;
import com.boot.develop.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("process user mode reqirement")
@RestController()
@RequestMapping("/user")
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	

	
	 @ApiOperation(value = "add new user")
	 @ApiResponses(value = {@ApiResponse(code = 200, message = "add success")})
	 @ApiImplicitParam(name = "user", value = "The user form post body ", required = true,
	   dataType="User",dataTypeClass=User.class,paramType="form")
	@PostMapping()
	public ResponseEntity<User> addUser(@Valid @RequestBody User user,Errors errors) {
		
		
		 System.err.println("=====add user:"+user);
		 System.err.println("=====add user:"+user);
		 System.err.println("=====add user:"+user);		 

		 
		
		if(errors.hasErrors()) {
			
			 System.err.println("=====has errors user:");		
			//throw new DataValidException(HttpStatus.BAD_REQUEST,errors);
			return userService.addUser(user)!=null ? ResponseEntity.status(HttpStatus.CREATED).body(user):ResponseEntity.status(HttpStatus.CREATED).body(user);
		}
		 user=userService.addUser(user);
		 System.err.println("=====return  errors user:"+user);	
		
		return user!=null ? ResponseEntity.status(HttpStatus.CREATED).body(user) :ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

}
