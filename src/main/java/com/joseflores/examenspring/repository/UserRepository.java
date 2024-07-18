package com.joseflores.examenspring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joseflores.examenspring.models.User;

public interface UserRepository  extends CrudRepository<User, Long>{
    List<User> findAll();

    User findByEmail(String email);

    boolean existsByEmail(String email);
}