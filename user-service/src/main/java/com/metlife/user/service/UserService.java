package com.metlife.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metlife.user.model.Customer;
import com.metlife.user.model.User;
import com.metlife.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> verifyUser(Customer customer) {
		Optional<User> user = userRepository.findById(customer.getEmail());
		return user;
	}

}
