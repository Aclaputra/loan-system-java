package com.enigmacamp.service.impl;

import com.enigmacamp.constant.ERole;
import com.enigmacamp.model.dto.request.auth.AuthAdminRequest;
import com.enigmacamp.model.dto.request.auth.AuthCustomerRequest;
import com.enigmacamp.model.dto.request.customer.CustomerRequest;
import com.enigmacamp.model.dto.response.auth.SigninResponse;
import com.enigmacamp.model.dto.response.auth.SignupResponse;
import com.enigmacamp.model.entity.AppUser;
import com.enigmacamp.model.entity.Customer;
import com.enigmacamp.model.entity.Role;
import com.enigmacamp.model.entity.User;
import com.enigmacamp.repository.UserRepository;
import com.enigmacamp.security.JwtUtil;
import com.enigmacamp.service.AuthService;
import com.enigmacamp.service.CustomerService;
import com.enigmacamp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final RoleService roleService;
    private final CustomerService customerService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignupResponse signupAdmin(AuthAdminRequest request) {
        try {
            List<Role> roles = new ArrayList<>();
            Role roleAdmin = roleService.getOrSave(ERole.ROLE_ADMIN);
            Role roleStaff = roleService.getOrSave(ERole.ROLE_STAFF);
            roles.add(roleAdmin);
            roles.add(roleStaff);

            User user = User.builder()
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .roles(roles)
                    .build();
            userRepository.save(user);

            return SignupResponse.builder()
                    .email(user.getEmail())
                    .roles(user.getRoles())
                    .build();

        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "user already exist");
        }
    }

    @Override
    public SignupResponse signupCustomer(AuthCustomerRequest request) {
        try {
            Role role = roleService.getOrSave(ERole.ROLE_CUSTOMER);
            List<Role> roles = new ArrayList<>();
            roles.add(role);

            User user = User.builder()
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .roles(roles)
                    .build();
            userRepository.save(user);

            CustomerRequest customerRequest = CustomerRequest.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .phone(request.getPhone())
                    .dateOfBirth(request.getDateOfBirth())
                    .status(request.getStatus())
                    .build();

            customerService.save(customerRequest, user);

            return SignupResponse.builder()
                    .email(user.getEmail())
                    .roles(roles)
                    .build();
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "user already exist");
        }
    }

    @Override
    public SigninResponse signin(AuthAdminRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail().toLowerCase(),
                    request.getPassword()
            ));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            AppUser appUser = (AppUser) authentication.getPrincipal();

            String token = jwtUtil.generateToken(appUser);

            return SigninResponse.builder()
                    .token(token)
                    .email(request.getEmail())
                    .roles(appUser.getRoles())
                    .build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "user not found " + e.getMessage());
        }
    }
}
