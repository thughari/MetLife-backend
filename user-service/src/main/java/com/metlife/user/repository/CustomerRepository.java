package com.metlife.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.metlife.user.model.Customer;

public interface UserRepository  extends MongoRepository<Customer, String>{

}
