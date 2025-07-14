package com.pemex.logistica.censos.service.impl;

import java.util.List;
import com.pemex.logistica.censos.entity.CalibracionEquipo;
import com.pemex.logistica.censos.repository.CalibracionEquipoRepository;
import com.pemex.logistica.censos.service.CalibracionEquipoService;

public class CalibracionEquipoServiceImp implements CalibracionEquipoService {

    private final CalibracionEquipoRepository calibracionEquipoRepository;

    public CalibracionEquipoServiceImp(CalibracionEquipoRepository calibracionEquipoRepository) {
        this.calibracionEquipoRepository = calibracionEquipoRepository;
    }

    @Override
    public List<CalibracionEquipo> findAll() {
        return calibracionEquipoRepository.findAll();
    }

    @Override
    public CalibracionEquipo findById(Long id) {
        return calibracionEquipoRepository.findById(id).orElse(null);
    }

    @Override
    public CalibracionEquipo save(CalibracionEquipo calibracionEquipo) {
        return calibracionEquipoRepository.save(calibracionEquipo);
    }

    @Override
    public void deleteById(Long id) {
        calibracionEquipoRepository.deleteById(id);
    }
    
}
