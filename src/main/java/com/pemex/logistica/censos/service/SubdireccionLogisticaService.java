package com.pemex.logistica.censos.service;

import java.util.List;

import com.pemex.logistica.censos.entity.SubdireccionLogistica;

public interface SubdireccionLogisticaService {

    // Define methods for CRUD operations on SubdireccionLogistica
    List<SubdireccionLogistica> findAll();

    SubdireccionLogistica findById(Long id);

    SubdireccionLogistica save(SubdireccionLogistica subdireccionLogistica);

    void deleteById(Long id);

    // Additional methods can be defined as needed

}
