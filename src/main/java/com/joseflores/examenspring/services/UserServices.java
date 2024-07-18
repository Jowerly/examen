package com.joseflores.examenspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseflores.examenspring.models.User;
import com.joseflores.examenspring.repository.UserRepository;
import com.joseflores.examenspring.security.PasswordEncoder;

@Service
public class UserServices {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {
        encryptUserPassword(user);
        user = repository.save(user);
        return user;
      }
      private void encryptUserPassword(User user) {
        String hashedPassword = PasswordEncoder
            .bCryptPasswordEncoder()
            .encode(user.getPassword());
    
        user.setPassword(hashedPassword);
      }
      public User findByEmail(String email) {
        return repository.findByEmail(email);
      }
      public User findById(Long userId) {
        Optional<User> user = repository.findById(userId);
        return user.isPresent() ? user.get() : null;
      }
      public boolean emailExists(String email) {
        return repository.existsByEmail(email);
      }
      public long getTotalUsers() {
        return repository.count();
      }
    
}