package com.enigmacamp.service;

import com.enigmacamp.constant.ERole;
import com.enigmacamp.model.entity.Role;

public interface RoleService {
    Role getOrSave(ERole role);
}
