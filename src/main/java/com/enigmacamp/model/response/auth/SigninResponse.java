package com.enigmacamp.model.response.auth;

import com.enigmacamp.model.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SigninResponse {
    private String email;
    private List<Role> roles;
    private String token;
}
