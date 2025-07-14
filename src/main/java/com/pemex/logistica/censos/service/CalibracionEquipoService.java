package com.pemex.logistica.censos.service;

import java.util.List;

import com.pemex.logistica.censos.entity.CalibracionEquipo;

public interface CalibracionEquipoService {

    // Define methods specific to CalibracionEquipoService here
    // For example:
    List<CalibracionEquipo> findAll();
    CalibracionEquipo findById(Long id);
    CalibracionEquipo save(CalibracionEquipo calibracionEquipo);
    void deleteById(Long id);
    
}
