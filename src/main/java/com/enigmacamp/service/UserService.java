package com.enigmacamp.service;

import com.enigmacamp.model.dto.request.user.UserRequest;
import com.enigmacamp.model.dto.response.user.UserResponse;
import com.enigmacamp.model.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService {
    UserResponse getById(String id);
    AppUser loadUserByUserId(String userId);
}
