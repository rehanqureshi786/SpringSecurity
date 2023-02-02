package com.security.app.service;

import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.security.app.model.User;
import com.security.app.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public String login(String username, String password) {
		Optional<User> customer = userRepo.login(username, password);
		System.out.println("Stage1 : "+customer);
		if (customer.isPresent()) {
			String token = UUID.randomUUID().toString();
			User custom = (User) customer.get();
			custom.setToken(token);
			userRepo.save(custom);
			return token;

		}
		return StringUtils.EMPTY;
	}

	@Override
	public Optional<User> findByToken(String token) {
		// TODO Auto-generated method stub

		Optional<User> customer = userRepo.findByToken(token);
		if (customer.isPresent()) {
			User customer1 = (User) customer.get();
			User user = new User(customer1.getUsername(), customer1.getPassword(), true, true, true, true,
					AuthorityUtils.createAuthorityList("USER"));
			return Optional.of(user);
		}
		return Optional.empty();
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}

}
