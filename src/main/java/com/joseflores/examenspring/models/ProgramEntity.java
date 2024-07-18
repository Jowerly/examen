package com.joseflores.examenspring.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programas")
public class ProgramEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "El titulo de la pelicula no puede estar vacio.")
    @Size(min = 5 , max = 40)
    private String title;
    @Column(unique = false)
    @NotEmpty(message = "La proveedora o Red no puede estar vacia.")
    @Size(min = 3 , max = 20)
    private String proveedor;
    @Column(unique = false)
    @NotEmpty(message = "La descripcion no puede estar vacia.")
    @Size(min = 30 , max = 150)
    private String descripcion;
    @Column(unique = false)
    @DecimalMin(value = "0.5", message = "La calificacion minima es un 0.5")
    @DecimalMax(value = "5" , message = "La calificacion maxima es 5")
    @NotEmpty(message = "La valoracion no puede estar vacia.")
    private Integer valoracion;
    
    @Column
    private Date createdAt;
    
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}