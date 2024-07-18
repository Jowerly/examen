package com.joseflores.examenspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseflores.examenspring.models.Role;
import com.joseflores.examenspring.models.User;
import com.joseflores.examenspring.repository.RolesRepository;

@Service
public class RolesServices {
    @Autowired
    private RolesRepository repository;

    public boolean save(User user) {
        String rolename = "ROLE_USUARIO";
        Optional<Role> optionalRole = repository.findByName(rolename);
        Role roles;
        if (optionalRole.isPresent()) {
            roles = optionalRole.get();
        } else {
        roles = new Role();
        roles.setName(rolename);
        repository.save(roles);
        }
        return user.getRoles().add(roles);
    }
    public Role findByName(String rolename){
        Optional<Role> role = repository.findByName(rolename);
        return role.isPresent() ? role.get() : null;
    }
}