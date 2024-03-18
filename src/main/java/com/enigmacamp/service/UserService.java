package com.enigmacamp.service;

import com.enigmacamp.model.dto.request.user.UserRequest;
import com.enigmacamp.model.dto.response.user.UserResponse;
import org.springframework.stereotype.Service;

public interface UserService {
    UserResponse getById(String id);
}
