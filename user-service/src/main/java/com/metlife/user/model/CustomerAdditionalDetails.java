package com.metlife.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Document(collection = "users")
public class CustomerAdditionalDetails {
    @Id
    private String id;
    private String name;
    private int age;
    private String sex;
    private double totalCholesterol;
    private double ldl;
    private double hdl;
    private int systolicBp;
    private int diastolicBp;
    private Boolean smoking;   // 0=No, 1=Yes
    private Boolean diabetes;  // 0=No, 1=Yes
    private Boolean heartAttack; // 0=No, 1=Yes
}