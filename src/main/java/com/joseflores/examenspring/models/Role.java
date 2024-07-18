package com.joseflores.examenspring.models;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(updatable = false)
    private Instant createdAt;
  
    private Instant updatedAt;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;       
    @PrePersist
  public void onCreate() {
    createdAt = Instant.now();
  }

  @PreUpdate
  public void onUpdate() {
    updatedAt = Instant.now();
  }
}