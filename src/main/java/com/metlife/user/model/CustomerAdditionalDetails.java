package com.metlife.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Document(collection = "users")
public class CustomerAdditionalDetails {
    @Id
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private String sex;
    @NonNull
    private double totalCholesterol;
    @NonNull
    private double ldl;
    @NonNull
    private double hdl;
    @NonNull
    private int systolicBp;
    @NonNull
    private int diastolicBp;
    @NonNull
    private Boolean smoking;  
    @NonNull // 0=No, 1=Yes
    private Boolean diabetes; 
    @NonNull // 0=No, 1=Yes
    private Boolean heartAttack; // 0=No, 1=Yes
}