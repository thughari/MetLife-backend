package com.metlife.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private int age;
    private int sex; // 0=Female, 1=Male
    private double totalCholesterol;
    private double ldl;
    private double hdl;
    private int systolicBp;
    private int diastolicBp;
    private int smoking;   // 0=No, 1=Yes
    private int diabetes;  // 0=No, 1=Yes
    private int heartAttack; // 0=No, 1=Yes
    private boolean isExistingUser; //true = existing, false = doen't exist
}
