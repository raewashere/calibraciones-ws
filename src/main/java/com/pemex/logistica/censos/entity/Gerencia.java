package com.pemex.logistica.censos.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "gerencia")
public class Gerencia {

    public Gerencia() {
        // Default constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gerencia", nullable = false)
    private Integer id_gerencia;

    @Column(name = "nombre_gerencia", nullable = false)
    private String nombre_gerencia;

    // Una gerencia pertenece a una subdirección
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subdireccion", nullable = false)
    @JsonBackReference
    private Subdireccion subdireccion;

    @OneToMany(mappedBy = "gerencia", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Instalacion> instalaciones; // List of installations associated with this management unit

}
