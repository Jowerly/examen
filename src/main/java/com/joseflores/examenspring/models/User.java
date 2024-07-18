package com.joseflores.examenspring.models;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre de usuario no puede estar vacio.")
    private String username;
    @NotEmpty(message = "El email no puede estar vacio.")
    @Email
    @Column(unique = false)
    private String email;
    @NotEmpty(message = "La contraseña no puede estar vacia.")
    private String password;
    @Transient
    private String confirmPassword;
    @Column(updatable =  false)
    private Instant createdAt;
    
    private Instant updatedAt;
    @ManyToAny(fetch = FetchType.EAGER)    
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @PrePersist
    public void onCreate(){
        createdAt = Instant.now();
    }
    @PreUpdate
    public void onUpdate(){
        updatedAt = Instant.now();
    }
} 