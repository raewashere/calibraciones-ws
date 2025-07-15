package com.pemex.logistica.censos.service.impl;

import com.pemex.logistica.censos.entity.TipoSensor;
import com.pemex.logistica.censos.service.TipoSensorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TipoSensorServiceImp implements TipoSensorService {

    private final com.pemex.logistica.censos.repository.TipoSensorRepository tipoSensorRepository;

    public TipoSensorServiceImp(com.pemex.logistica.censos.repository.TipoSensorRepository tipoSensorRepository) {
        this.tipoSensorRepository = tipoSensorRepository;
    }

    @Override
    public List<TipoSensor> findAll() {
        return tipoSensorRepository.findAll();
    }

    @Override
    public TipoSensor findById(Long id) {
        return tipoSensorRepository.findById(id).orElse(null);
    }

    @Override
    public TipoSensor save(TipoSensor tipoSensor) {
        return tipoSensorRepository.save(tipoSensor); // Replace with actual implementation
    }

    @Override
    public void deleteById(Long id) {
        tipoSensorRepository.deleteById(id); // Replace with actual implementation
    }
    
}
