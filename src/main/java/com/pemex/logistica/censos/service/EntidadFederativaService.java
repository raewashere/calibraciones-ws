package com.pemex.logistica.censos.service;

import java.util.List;

import com.pemex.logistica.censos.entity.EntidadFederativa;

public interface EntidadFederativaService {
    // Define methods specific to EntidadFederativaService here
    // For example:
    List<EntidadFederativa> findAll();

    EntidadFederativa findById(Long id);

    EntidadFederativa save(EntidadFederativa entidadFederativa);

    void deleteById(Long id);
}
