package com.metlife.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metlife.user.model.Customer;
import com.metlife.user.model.CustomerAdditionalDetails;
import com.metlife.user.model.dto.UserLogin;
import com.metlife.user.repository.CustomerAdditionalRepository;
import com.metlife.user.repository.CustomerRepository;

@Service
public class UserService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerAdditionalRepository customerAdditionalRepository;
	
	public Optional<Customer> verifyUser(UserLogin loginUser) {
		Optional<Customer> customer = customerRepository.findById(loginUser.getEmail());
		return customer;
	}
	
	public Optional<CustomerAdditionalDetails> findByUsername(String username) {
	    return customerAdditionalRepository.findById(username); // or by username field if different
	}

	public CustomerAdditionalDetails updateHealthData(CustomerAdditionalDetails updatedData) {
        Optional<CustomerAdditionalDetails> userOpt = findByUsername(updatedData.getId());
        if (userOpt.isEmpty()) return null;

        CustomerAdditionalDetails user = userOpt.get();

        if (updatedData.getAge() != 0) user.setAge(updatedData.getAge());
        if (updatedData.getSex() != null) user.setSex(updatedData.getSex());
        if (updatedData.getTotalCholesterol() != 0) user.setTotalCholesterol(updatedData.getTotalCholesterol());
        if (updatedData.getLdl() != 0) user.setLdl(updatedData.getLdl());
        if (updatedData.getHdl() != 0) user.setHdl(updatedData.getHdl());
        if (updatedData.getSystolicBp() != 0) user.setSystolicBp(updatedData.getSystolicBp());
        if (updatedData.getDiastolicBp() != 0) user.setDiastolicBp(updatedData.getDiastolicBp());
        if (updatedData.getSmoking() != null) user.setSmoking(updatedData.getSmoking());
        if (updatedData.getDiabetes() != null) user.setDiabetes(updatedData.getDiabetes());
        if (updatedData.getHeartAttack() != null) user.setHeartAttack(updatedData.getHeartAttack());

        return customerAdditionalRepository.save(user);
    }
	
	


}
