package com.metlife.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metlife.user.model.Customer;
import com.metlife.user.model.dto.UserLogin;
import com.metlife.user.service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/verfyUser")
	public ResponseEntity<?> VerifyUser(@RequestBody UserLogin loginUser) {
		
		Optional<Customer> user = userService.verifyUser(loginUser);
		
		if (user.isPresent())
	        return ResponseEntity.ok(user.get());
		
		return ResponseEntity.ok(false);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody String entity) {		
		return null;
	}
	
	
}
