package com.metlife.user.util;

import java.util.ArrayList;
import java.util.List;

import com.metlife.user.model.CustomerAdditionalDetails;

public class HealthDataValidator {
    public static List<String> getMissingFields(CustomerAdditionalDetails customer) {
        List<String> missing = new ArrayList<>();
        
        if (customer.getAge() == 0) missing.add("age");
        if (customer.getSex() == null) missing.add("sex");
        if (customer.getTotalCholesterol() == 0) missing.add("totalCholesterol");
        if (customer.getLdl() == 0) missing.add("ldl");
        if (customer.getHdl() == 0) missing.add("hdl");
        if (customer.getSystolicBp() == 0) missing.add("systolicBp");
        if (customer.getDiastolicBp() == 0) missing.add("diastolicBp");
        if (customer.getSmoking() == null) missing.add("smoking");
        if (customer.getDiabetes() == null) missing.add("diabetes");
        if (customer.getHeartAttack() == null) missing.add("heartAttack");
        
        return missing;
    }
}

