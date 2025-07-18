package com.pemex.logistica.censos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pemex.logistica.censos.entity.Direccion;
import com.pemex.logistica.censos.repository.DireccionRepository;
import com.pemex.logistica.censos.service.DireccionService;

@Service
public class DireccionServiceImp implements DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionServiceImp(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    // Implement the methods defined in the DireccionService interface
    @Override
    public List<Direccion> findAll() {
        // Implementation logic to retrieve all Direccion entities
        return direccionRepository.findAll();
    }

    @Override
    public Direccion findById(Long id) {
        // Implementation logic to find a Direccion by its ID
        return direccionRepository.findById(id).orElse(null); // Replace with actual implementation
    }

    @Override
    public Direccion save(Direccion direccion) {
        // Implementation logic to save a Direccion entity
        return direccionRepository.save(direccion); // Replace with actual implementation
    }

    @Override
    public void deleteById(Long id) {
        // Implementation logic to delete a Direccion by its ID
        // Replace with actual implementation
        direccionRepository.deleteById(id); // Replace with actual implementation
    }

}
