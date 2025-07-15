package com.pemex.logistica.censos.service.impl;

import java.util.List;

import com.pemex.logistica.censos.entity.SubdireccionLogistica;
import com.pemex.logistica.censos.repository.SubdireccionLogisticaRepository;
import com.pemex.logistica.censos.service.SubdireccionLogisticaService;

public class SubdireccionLogisticaServiceImp implements SubdireccionLogisticaService {

    private final SubdireccionLogisticaRepository subdireccionLogisticaRepository;

    public SubdireccionLogisticaServiceImp(SubdireccionLogisticaRepository subdireccionLogisticaRepository) {
        this.subdireccionLogisticaRepository = subdireccionLogisticaRepository;
    }

    @Override
    public List<SubdireccionLogistica> findAll() {
        return subdireccionLogisticaRepository.findAll();
    }

    @Override
    public SubdireccionLogistica findById(Long id) {
        return subdireccionLogisticaRepository.findById(id).orElse(null);
    }

    @Override
    public SubdireccionLogistica save(SubdireccionLogistica subdireccionLogistica) {
        return subdireccionLogisticaRepository.save(subdireccionLogistica);
    }

    @Override
    public void deleteById(Long id) {
        subdireccionLogisticaRepository.deleteById(id);
    }
    
}
