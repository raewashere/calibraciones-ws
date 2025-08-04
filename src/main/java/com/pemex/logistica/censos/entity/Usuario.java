package com.pemex.logistica.censos.entity;

import lombok.Data;
import jakarta.persistence.Table;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    public Usuario() {
        // Default constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id_usuario;

    @Column(name = "correo_electronico", nullable = false)
    private String correo_electronico;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "primer_apellido", nullable = false)
    private String primer_apellido;

    @Column(name = "segundo_apellido", nullable = true)
    private String segundo_apellido;

    @Column(name = "telefono", nullable = true)
    private String telefono;

    @Column(name = "rol", nullable = false)
    private String rol; // e.g., "ADMIN", "USER", etc.

    @Column(name = "verificacion_admin", nullable = false)
    private Boolean verificacion_admin; // Indicates if the user is verified by an admin

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CalibracionEquipo> calibraciones;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instalacion", nullable = false)
    @JsonBackReference
    private Instalacion instalacion;

}
