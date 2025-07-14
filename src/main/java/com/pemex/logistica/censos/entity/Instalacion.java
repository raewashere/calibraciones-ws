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
@Table(name = "instalacion")
public class Instalacion {
    
    public Instalacion(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instalacion", nullable = false)
    private Integer id_instalacion; // Unique identifier for the entity

    @Column(name = "nombre_instalacion", nullable = false)
    private String nombre_instalacion;

    @Column(name = "region_fiscal", nullable = false)
    private String region_fiscal;

    // Una instalacion de estación pertenece a una subdirección
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subdireccion", nullable = false)
    @JsonBackReference
    private Subdireccion subdireccion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gerencia", nullable = false)
    @JsonBackReference
    private Gerencia gerencia;

    // Una instalacion de estación pertenece a una entidad federativa
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entidad", nullable = false)
    @JsonBackReference
    private EntidadFederativa entidad_federativa;

    // Una instalacion de estación tiene varios transportes ducto
    @OneToMany(mappedBy = "instalacion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TransporteDucto> lista_transporte_ducto;

}
