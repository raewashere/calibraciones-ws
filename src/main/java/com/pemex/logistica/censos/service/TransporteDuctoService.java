package com.pemex.logistica.censos.service;

import java.util.List;
import com.pemex.logistica.censos.entity.TransporteDucto;

public interface TransporteDuctoService {

    // Define methods specific to TransporteDuctoService here
    // For example:
    List<TransporteDucto> findAll();

    TransporteDucto findById(Long id);

    TransporteDucto save(TransporteDucto transporteDucto);

    void deleteById(Long id);
}