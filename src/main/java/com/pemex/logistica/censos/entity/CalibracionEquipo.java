package com.pemex.logistica.censos.entity;

import java.sql.Date;
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
@Table(name = "calibracion_equipo")
public class CalibracionEquipo {

    public CalibracionEquipo() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calibracion", nullable = false)
    private Integer id_calibracion;

    @Column(name = "certificado_calibracion", nullable = false)
    private String certificado_calibracion;

    @Column(name = "fecha_calibracion", nullable = false)
    private Date fecha_calibracion;

    @Column(name = "fecha_proxima_calibracion", nullable = false)
    private Date fecha_proxima_calibracion;

    @Column(name = "linealidad", nullable = false)
    private float linealidad;

    @Column(name = "reproducibilidad", nullable = true)
    private float reproducibilidad;

    @Column(name = "observaciones", nullable = true)
    private String observaciones;

    @Column(name = "documento_certificado", nullable = true)
    private String documento_certificado;

    // una calibración de equipo pertenece a un laboratorio de calibración
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_laboratorio_calibracion", nullable = false)
    @JsonBackReference
    private LaboratorioCalibracion id_laboratorio_calibracion;

    // Una calibración de equipo pertenece a un equipo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_equipo", nullable = false)
    @JsonBackReference
    private Equipo equipo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = true)
    @JsonBackReference
    private Usuario usuario;    

    // Una calibración de equipo pertenece a varias corridas
    @OneToMany(mappedBy = "calibracion_equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Corrida> lista_corridas;



}
