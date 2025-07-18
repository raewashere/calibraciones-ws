package com.pemex.logistica.censos.service;

import java.util.List;
import com.pemex.logistica.censos.entity.LaboratorioCalibracion;

public interface LaboratorioCalibracionService {

    // Define methods specific to LaboratorioCalibracionService here
    // For example:
    List<LaboratorioCalibracion> findAll();

    LaboratorioCalibracion findById(Long id);

    LaboratorioCalibracion save(LaboratorioCalibracion laboratorioCalibracion);

    void deleteById(Long id);
}
