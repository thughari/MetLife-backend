package com.metlife.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metlife.user.model.Customer;
import com.metlife.user.model.CustomerAdditionalDetails;
import com.metlife.user.model.dto.UserLogin;
import com.metlife.user.service.UserService;
import com.metlife.user.util.HealthDataValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/validateData/{username}")
    public ResponseEntity<?> validateData(@PathVariable String username) {
        Optional<CustomerAdditionalDetails> userOpt = userService.findByUsername(username);

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        CustomerAdditionalDetails user = userOpt.get();
        List<String> missingFields = HealthDataValidator.getMissingFields(user);

        return ResponseEntity.ok(missingFields);
    }
	
	@PostMapping("/updateHealthData")
	public ResponseEntity<?> updateHealthData(@RequestBody CustomerAdditionalDetails updatedData) {
		CustomerAdditionalDetails updatedUser = userService.updateHealthData(updatedData);

        if (updatedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        List<String> remainingMissingFields = HealthDataValidator.getMissingFields(updatedUser);

        return ResponseEntity.ok(Map.of(
                "user", updatedUser,
                "remainingMissingFields", remainingMissingFields
        ));
	}
	
	
	
	
	
	//if missing health data ask for the mandatory data with /validateData with username

	
	//	@PostMapping("/register")
//	public ResponseEntity<?> registerUser(@RequestBody String entity) {		
//		return null;
//	}
//	
//	
//	
	
}
