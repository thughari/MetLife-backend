package com.metlife.user.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "customers")
public class Customer {
	
    @Id
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private String insurancePlan;
    private LocalDateTime registrationDate;
    private boolean isInsured;
    private double totalClaims;
    private double totalPremium;
    private int rewardPoints;

}