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
@Table(name = "laboratorio_calibracion")
public class LaboratorioCalibracion {

    public LaboratorioCalibracion() {
        // Default constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratorio_calibracion", nullable = false)
    private Integer id_laboratorio_calibracion;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    // un laboratorio de calibración puede hacer varias calibraciones
    @OneToOne(mappedBy = "id_laboratorio_calibracion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private CalibracionEquipo calibracion_equipo;
}
