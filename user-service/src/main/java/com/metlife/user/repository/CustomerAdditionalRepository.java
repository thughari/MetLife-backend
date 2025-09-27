package com.metlife.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.metlife.user.model.CustomerAdditionalDetails;


public interface CustomerAdditionalRepository extends MongoRepository<CustomerAdditionalDetails, String> {

}
