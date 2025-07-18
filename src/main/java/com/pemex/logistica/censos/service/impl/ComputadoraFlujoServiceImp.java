package com.pemex.logistica.censos.service.impl;

import java.util.List;

import com.pemex.logistica.censos.entity.ComputadoraFlujo;
import com.pemex.logistica.censos.repository.ComputadoraFlujoRepository;
import com.pemex.logistica.censos.service.ComputadoraFlujoService;
import org.springframework.stereotype.Service;

@Service
public class ComputadoraFlujoServiceImp implements ComputadoraFlujoService {

    private final ComputadoraFlujoRepository computadoraFlujoRepository;

    public ComputadoraFlujoServiceImp(ComputadoraFlujoRepository computadoraFlujoRepository) {
        this.computadoraFlujoRepository = computadoraFlujoRepository;
    }

    @Override
    public List<com.pemex.logistica.censos.entity.ComputadoraFlujo> findAll() {
        return computadoraFlujoRepository.findAll();
    }

    @Override
    public ComputadoraFlujo findById(String id) {
        return computadoraFlujoRepository.findById(id).orElse(null);
    }

    @Override
    public ComputadoraFlujo save(ComputadoraFlujo computadoraFlujo) {
        return computadoraFlujoRepository.save(computadoraFlujo);
    }

    @Override
    public void deleteById(String id) {
        computadoraFlujoRepository.deleteById(id);
    }

}
