package com.pemex.logistica.censos.service;

import java.util.List;
import com.pemex.logistica.censos.entity.Subdireccion;

public interface SubdireccionService {

    List<Subdireccion> findAll();
    Subdireccion findById(Long id);
    Subdireccion save(Subdireccion subdireccion);
    void deleteById(Long id);

    
}
