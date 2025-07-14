package com.pemex.logistica.censos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "corrida")
public class Corrida {
    
    public Corrida() {
        // Constructor por defecto
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corrida", nullable = false)  
    private Integer id_corrida;

    @Column(name = "caudal", nullable = false)
    private Float caudal;

    @Column(name = "temperatura", nullable = false)
    private Float temperatura;

    @Column(name = "presion", nullable = false)
    private Float presion;

    @Column(name = "meter_factor", nullable = false)
    private Float meter_factor;

    @Column(name = "k_factor_pulsos_m3", nullable = false)
    private Float k_factor_pulsos_m3;

    @Column(name = "k_factor_pulsos_bbl", nullable = false)
    private Float k_factor_pulsos_bbl;

    @Column(name = "frecuencia", nullable = false)
    private Float frecuencia;

    @Column(name = "repetibilidad", nullable = false)
    private Float repetibilidad;

    //Una corrida pertenece a una calibracion
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_calibracion", nullable = false)
    @JsonBackReference
    private CalibracionEquipo calibracion_equipo;
}
