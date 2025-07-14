package com.pemex.logistica.censos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tipo_sensor")
public class TipoSensor {
    public TipoSensor() {
        // Default constructor
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_sensor", nullable = false)
    private Integer id_tipo_sensor; // Unique identifier for the entity

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    // Un tipo de sensor puede estar asociado a varios equipos de medición
    @OneToOne(mappedBy = "tipo_sensor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Equipo equipo;
}
