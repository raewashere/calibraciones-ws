package com.pemex.logistica.censos.service;

import java.util.List;

import com.pemex.logistica.censos.entity.Direccion;

public interface DireccionService {

    List<Direccion> findAll();
    Direccion findById(Long id);
    Direccion save(Direccion direccion);
    void deleteById(Long id);
    
    
}
