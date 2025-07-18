package com.pemex.logistica.censos.service;

import java.util.List;

import com.pemex.logistica.censos.entity.Gerencia;

public interface GerenciaService {

    // Define methods specific to GerenciaService here
    // For example:
    List<Gerencia> findAll();

    Gerencia findById(Long id);

    Gerencia save(Gerencia gerencia);

    void deleteById(Long id);
}