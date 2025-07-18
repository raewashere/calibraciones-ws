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
@Table(name = "entidad_federativa")
public class EntidadFederativa {

    public EntidadFederativa() {
        // Default constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad", nullable = false)
    private Integer id_entidad; // Unique identifier for the entity

    @Column(name = "nombre_entidad", nullable = false)
    private String nombre_entidad; // Name of the state or entity

    // Una entidad federativa puede tener varias instalaciones
    @OneToMany(mappedBy = "entidad_federativa", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Instalacion> instalaciones;

}
