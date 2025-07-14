package com.pemex.logistica.censos.service;

import java.util.List;

import com.pemex.logistica.censos.entity.TipoSensor;

public interface TipoSensorService {
    // Define methods specific to TipoSensorService here
    // For example:
    List<TipoSensor> findAll();
    TipoSensor findById(Long id);
    TipoSensor save(TipoSensor tipoSensor);
    void deleteById(Long id);
}
