package com.pemex.logistica.censos.service;

import java.util.List;
import com.pemex.logistica.censos.entity.Corrida;

public interface CorridaService {
    
    // Define methods specific to CorridaService here
    // For example:
    List<Corrida> findAll();
    Corrida findById(Long id);
    Corrida save(Corrida corrida);
    void deleteById(Long id);
}
