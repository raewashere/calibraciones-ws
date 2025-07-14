package com.pemex.logistica.censos.service.impl;

import java.util.List;

import com.pemex.logistica.censos.repository.EntidadFederativaRespository;
import com.pemex.logistica.censos.service.EntidadFederativaService;

public class EntidadFederativaServiceImp implements EntidadFederativaService {

    private final EntidadFederativaRespository entidadFederativaRepository;

    public EntidadFederativaServiceImp(EntidadFederativaRespository entidadFederativaRepository) {
        this.entidadFederativaRepository = entidadFederativaRepository;
    }

    @Override
    public List<com.pemex.logistica.censos.entity.EntidadFederativa> findAll() {
        return entidadFederativaRepository.findAll();
    }

    @Override
    public com.pemex.logistica.censos.entity.EntidadFederativa findById(Long id) {
        return entidadFederativaRepository.findById(id).orElse(null);
    }

    @Override
    public com.pemex.logistica.censos.entity.EntidadFederativa save(com.pemex.logistica.censos.entity.EntidadFederativa entidadFederativa) {
        return entidadFederativaRepository.save(entidadFederativa);
    }

    @Override
    public void deleteById(Long id) {
        entidadFederativaRepository.deleteById(id);
    }
    
}
