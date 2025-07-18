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
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "subdireccion")
public class Subdireccion {

    public Subdireccion() {
        // Default constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subdireccion", nullable = false)
    private Integer id_subdireccion;

    @Column(name = "nombre_subdireccion", nullable = false)
    private String nombre_subdireccion;

    // Una subdirección pertenece a una dirección
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion", nullable = false)
    @JsonBackReference
    private Direccion direccion;

    // Una subdirección puede tener varias instalaciones
    @OneToMany(mappedBy = "subdireccion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Instalacion> instalaciones;

}
