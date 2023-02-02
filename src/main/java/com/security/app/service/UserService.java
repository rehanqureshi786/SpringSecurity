package com.security.app.service;

import java.util.Optional;

import com.security.app.model.User;


public interface UserService {

	public String login(String username,String password);
	public Optional<User> findByToken(String token);
	public User findById(Integer id);
	
	
	
}
