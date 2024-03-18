package com.enigmacamp.service;

import com.enigmacamp.model.dto.request.auth.AuthRequest;
import com.enigmacamp.model.dto.response.auth.SigninResponse;
import com.enigmacamp.model.dto.response.auth.SignupResponse;

public interface AuthService {
    SignupResponse signup(AuthRequest request);
    SigninResponse signin(AuthRequest request);
}
