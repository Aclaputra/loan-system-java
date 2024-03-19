package com.enigmacamp.service.impl;

import com.enigmacamp.model.dto.request.user.UserRequest;
import com.enigmacamp.model.dto.response.user.UserResponse;
import com.enigmacamp.model.entity.AppUser;
import com.enigmacamp.model.entity.User;
import com.enigmacamp.repository.UserRepository;
import com.enigmacamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Override
    public AppUser loadUserByUserId(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("invalid credential user"));

        return AppUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        return AppUser.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }
}
