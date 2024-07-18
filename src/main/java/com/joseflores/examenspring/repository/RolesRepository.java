package com.joseflores.examenspring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.joseflores.examenspring.models.Role;

public interface RolesRepository extends CrudRepository<Role, Long>{
    Optional<Role> findByName(String name);
}