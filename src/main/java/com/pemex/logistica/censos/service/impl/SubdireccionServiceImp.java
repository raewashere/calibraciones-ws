package com.pemex.logistica.censos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pemex.logistica.censos.entity.Subdireccion;
import com.pemex.logistica.censos.repository.SubdireccionRepository;
import com.pemex.logistica.censos.service.SubdireccionService;

@Service
public class SubdireccionServiceImp implements SubdireccionService {

    private final SubdireccionRepository subdireccionRepository;

    public SubdireccionServiceImp(SubdireccionRepository subdireccionRepository) {
        this.subdireccionRepository = subdireccionRepository;
    }

    @Override
    public List<Subdireccion> findAll() {
        // Implementation logic to retrieve all Subdireccion entities
        return subdireccionRepository.findAll(); 
    }

    @Override
    public Subdireccion findById(Long id) {
        // Implementation logic to find a Subdireccion by its ID
        return subdireccionRepository.findById(id).orElse(null); // Replace with actual implementation
    }

    @Override
    public Subdireccion save(Subdireccion subdireccion) {
        // Implementation logic to save a Subdireccion entity
        return subdireccionRepository.save(subdireccion); // Replace with actual implementation
    }

    @Override
    public void deleteById(Long id) {
        // Implementation logic to delete a Subdireccion by its ID
        subdireccionRepository.deleteById(id); // Replace with actual implementation

    }

}   
