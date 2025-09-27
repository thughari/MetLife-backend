package com.metlife.user.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "customers")
public class Customer {
	
    @Id
	@NonNull
    private String customerId;
	@NonNull
    private String name;
	@NonNull
    private String email;
	@NonNull
    private String phone;
	@NonNull
    private String insurancePlan;
	@NonNull
    private LocalDateTime registrationDate;
	@NonNull
    private boolean isInsured;
	@NonNull
    private double totalClaims;
	@NonNull
    private double totalPremium;


}