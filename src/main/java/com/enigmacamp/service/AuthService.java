package com.enigmacamp.service;

import com.enigmacamp.model.dto.request.auth.AuthAdminRequest;
import com.enigmacamp.model.dto.request.auth.AuthCustomerRequest;
import com.enigmacamp.model.dto.request.customer.CustomerRequest;
import com.enigmacamp.model.dto.response.auth.SigninResponse;
import com.enigmacamp.model.dto.response.auth.SignupResponse;

public interface AuthService {
    SignupResponse signupAdmin(AuthAdminRequest request);
    SignupResponse signupCustomer(AuthCustomerRequest request);
    SigninResponse signin(AuthAdminRequest request);
}
