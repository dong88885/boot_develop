package com.boot.develop.service;

import org.springframework.stereotype.Service;

import com.boot.develop.dao.UserRepostory;
import com.boot.develop.entity.User;

@Service
public class UserServiceImpl implements UserService {
	 
	
	private UserRepostory  userRepostory;

	@Override
	public Integer addUser(User user) {

		return userRepostory.addUser(user);
	}

}
