package com.pemex.logistica.censos.service;

import java.util.List;

import com.pemex.logistica.censos.entity.Equipo;

public interface EquipoService {
    // Define methods specific to EquipoService here
    // For example:
    List<Equipo> findAll();

    Equipo findById(String id);

    Equipo save(Equipo equipo);

    void deleteById(String id);

}
