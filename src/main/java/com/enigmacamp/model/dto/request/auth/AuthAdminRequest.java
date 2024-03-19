package com.enigmacamp.model.dto.request.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthAdminRequest {
    private String email;
    private String password;
}
