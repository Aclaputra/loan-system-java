package com.enigmacamp.model.response.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String phone;
    private String status;
}
