package com.enigmacamp.service;

import com.enigmacamp.model.request.AuthRequest;
import com.enigmacamp.model.response.auth.SigninResponse;
import com.enigmacamp.model.response.auth.SignupResponse;

public interface AuthService {
    SignupResponse signup(AuthRequest request);
    SigninResponse signin(AuthRequest request);
}
