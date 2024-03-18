package com.enigmacamp.service;

import com.enigmacamp.model.request.SigninRequest;
import com.enigmacamp.model.request.SignupRequest;
import com.enigmacamp.model.response.auth.SigninResponse;
import com.enigmacamp.model.response.auth.SignupResponse;

public interface AuthService {
    SignupResponse signup(SignupRequest request);
    SigninResponse signin(SigninRequest request);
}
