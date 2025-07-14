package com.pemex.logistica.censos.service;

import java.util.List;
import com.pemex.logistica.censos.entity.Instalacion;

public interface InstalacionService {
    // Define methods specific to InstalacionService here
    // For example:
    List<Instalacion> findAll();
    Instalacion findById(Long id);
    Instalacion save(Instalacion instalacion);
    void deleteById(Long id);
}
