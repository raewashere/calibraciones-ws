package com.pemex.logistica.censos.service.impl;

import java.util.List;

import com.pemex.logistica.censos.entity.Corrida;
import com.pemex.logistica.censos.repository.CorridaRepository;
import com.pemex.logistica.censos.service.CorridaService;
import org.springframework.stereotype.Service;

@Service
public class CorridaServiceImp implements CorridaService {

    private final CorridaRepository corridaRepository;

    public CorridaServiceImp(CorridaRepository corridaRepository) {
        this.corridaRepository = corridaRepository;
    }

    @Override
    public List<Corrida> findAll() {
        return corridaRepository.findAll();
    }

    @Override
    public Corrida findById(Long id) {
        return corridaRepository.findById(id).orElse(null);
    }

    @Override
    public Corrida save(Corrida corrida) {
        return corridaRepository.save(corrida); // Replace with actual implementation
    }

    @Override
    public void deleteById(Long id) {
        corridaRepository.deleteById(id); // Replace with actual implementation
    }

}
