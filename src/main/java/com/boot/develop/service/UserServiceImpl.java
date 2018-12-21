package com.boot.develop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.develop.dao.UserRepostory;
import com.boot.develop.entity.User;

@Service
public class UserServiceImpl implements UserService {
	 
	@Autowired
	private UserRepostory  userRepostory;

	@Override
	public User addUser(User user) {

		return userRepostory.save(user);
	}

}
