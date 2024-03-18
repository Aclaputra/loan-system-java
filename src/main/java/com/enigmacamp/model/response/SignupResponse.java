package com.enigmacamp.model.response;

import com.enigmacamp.model.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SignupResponse {
    private String email;
    private List<Role> roles;
}
