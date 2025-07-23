package com.pemex.logistica.censos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transporte_ducto")
public class TransporteDucto {

    public TransporteDucto() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transporte_ducto", nullable = false)
    private Integer id_transporte_ducto; // Unique identifier for the entity

    @Column(name = "tipo_fluido", nullable = false)
    private String tipo_fluido;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instalacion", nullable = false)
    @JsonBackReference
    private Instalacion instalacion;

    // Un trasporte ducto puede tener una o varias computadoras de flujo
    @OneToMany(mappedBy = "transporte_ducto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ComputadoraFlujo> lista_computadora_flujo;

    // Un transporte ducto tiene varios equipos de medición
    @OneToMany(mappedBy = "transporte_ducto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Equipo> lista_equipo_medicion;

}
