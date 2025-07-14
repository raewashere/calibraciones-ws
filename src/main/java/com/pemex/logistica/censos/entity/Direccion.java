package com.pemex.logistica.censos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "direccion")
public class Direccion {

    public Direccion() {
        // Default constructor
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion", nullable = false)
    private Integer id_direccion; // Unique identifier for the entity

    @Column(name = "nombre_direccion", nullable = false)
    private String nombre_direccion;

    //Una dirección puede tener varias subdirecciones
    @OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Subdireccion> subdirecciones;
    
}
