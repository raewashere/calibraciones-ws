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
@Table(name = "computadora_flujo")
public class ComputadoraFlujo {

    public ComputadoraFlujo() {
    }

    @Id
    @Column(name = "tag_computadora_flujo", nullable = false)
    private String tag_computadora_flujo; // Unique identifier for the entity

    @Column(name = "puerto_disponible", nullable = false)
    private String puerto_disponible;

    @Column(name = "configuracion_puerto", nullable = false)
    private String configuracion_puerto;

    @Column(name = "protocolo", nullable = false)
    private String protocolo;

    @Column(name = "vesion_software", nullable = false)
    private String vesion_software;

    // una computadora de flujo pertenece a un transporte ducto
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transporte_ducto", nullable = false)
    @JsonBackReference
    private TransporteDucto transporte_ducto;

    // Una computadora de flujo tiene varios equipos de medición
    @OneToMany(mappedBy = "computadora_flujo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Equipo> lista_equipos_medicion;
}
