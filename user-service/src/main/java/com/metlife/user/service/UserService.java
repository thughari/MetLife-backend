package com.metlife.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metlife.user.model.Customer;
import com.metlife.user.model.dto.UserLogin;
import com.metlife.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<Customer> verifyUser(UserLogin loginUser) {
		Optional<Customer> customer = userRepository.findById(loginUser.getEmail());
		return customer;
	}

}
