package com.enigmacamp.service.impl;

import com.enigmacamp.constant.ERole;
import com.enigmacamp.model.entity.Role;
import com.enigmacamp.repository.RoleRepository;
import com.enigmacamp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role getOrSave(ERole role) {
        Optional<Role> optionalRole = roleRepository.findByName(role);
        /**
         * kalau ada balikin dari database
         */
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        }

        /**
         * kaalu ada kita buat baru
         */
        Role currentRole = Role.builder()
                .name(role)
                .build();

        return roleRepository.saveAndFlush(currentRole);
    }
}
