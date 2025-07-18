package com.pemex.logistica.censos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "equipo")
public class Equipo {
    public Equipo() {
        // Default constructor
    }

    @Id
    @Column(name = "tag_equipo", nullable = false)
    private String tag_equipo;

    @Column(name = "tipo_medicion", nullable = false)
    private String tipo_medicion;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "no_serie", nullable = false)
    private String no_serie;

    @Column(name = "intervalo_calibracion", nullable = false)
    private Integer intervalo_calibracion;

    @Column(name = "intervalo_verificacion", nullable = false)
    private Integer intervalo_verificacion;

    @Column(name = "incertidumbre", nullable = false)
    private Float incertidumbre;

    @Column(name = "magnitud_incertidumbre", nullable = false)
    private String magnitud_incertidumbre;

    // Un equipo de medicion esta conectadad a una computadora de flujo
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_computadora_flujo", nullable = true)
    @JsonBackReference
    private ComputadoraFlujo computadora_flujo;

    // Un equipo de medicion es un tipo de sensor
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_sensor", nullable = false)
    @JsonBackReference
    private TipoSensor tipo_sensor;

    // Un equipo de medicion tiene multiples calibraciones
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CalibracionEquipo> lista_calibraciones;

    // Un equipo de medicion pertenece a un transporte ducto
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transporte_ducto", nullable = true)
    @JsonBackReference
    private TransporteDucto transporte_ducto;
}
