package com.metlife.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.metlife.user.model.Customer;

public interface CustomerRepository  extends MongoRepository<Customer, String>{

}
