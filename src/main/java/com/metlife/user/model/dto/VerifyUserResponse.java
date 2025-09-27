package com.metlife.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

import com.metlife.user.model.CustomerAdditionalDetails;

@Data
@AllArgsConstructor
public class VerifyUserResponse {
    private boolean exists;
    private CustomerAdditionalDetails customer;
    private List<String> missingFields;
}
