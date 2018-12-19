package com.boot.develop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.develop.entity.User;

public interface  UserRepostory extends JpaRepository<User, Integer>{
  

		public Optional<User> findById(Integer id);
		
		public int addUser(User user);
		 
		
}
