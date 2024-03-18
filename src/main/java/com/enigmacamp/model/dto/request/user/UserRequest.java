package com.enigmacamp.model.dto.request.user;

import com.enigmacamp.model.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserRequest {
    private String email;
    private List<Role> roles;
}