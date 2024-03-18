package com.enigmacamp.service;

public interface AuthService {
    SignupResponse signup(SignupRequest request);
    SigninResponse signin(SigninRequest request);
}
