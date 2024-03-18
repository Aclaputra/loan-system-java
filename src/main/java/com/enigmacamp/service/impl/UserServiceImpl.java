package com.enigmacamp.service.impl;

import com.enigmacamp.model.dto.request.user.UserRequest;
import com.enigmacamp.model.dto.response.user.UserResponse;
import com.enigmacamp.model.entity.User;
import com.enigmacamp.repository.UserRepository;
import com.enigmacamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse getById(String id) {
        User user = userRepository.findById(id).get();
        return UserResponse.builder()
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }
}
