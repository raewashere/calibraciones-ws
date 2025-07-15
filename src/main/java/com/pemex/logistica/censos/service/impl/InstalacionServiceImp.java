package com.pemex.logistica.censos.service.impl;

import java.util.List;

import com.pemex.logistica.censos.entity.Instalacion;
import com.pemex.logistica.censos.repository.InstalacionRepository;
import com.pemex.logistica.censos.service.InstalacionService;
import org.springframework.stereotype.Service;

@Service
public class InstalacionServiceImp implements InstalacionService {

    // Assuming you have a repository for Instalacion
    private final InstalacionRepository instalacionRepository;

    public InstalacionServiceImp(InstalacionRepository instalacionRepository) {
        this.instalacionRepository = instalacionRepository;
    }

    @Override
    public List<Instalacion> findAll() {
        return instalacionRepository.findAll();
    }

    @Override
    public Instalacion findById(Long id) {
        return instalacionRepository.findById(id).orElse(null);
    }

    @Override
    public Instalacion save(Instalacion instalacion) {
        return instalacionRepository.save(instalacion); // Replace with actual implementation
    }

    @Override
    public void deleteById(Long id) {
        instalacionRepository.deleteById(id); // Replace with actual implementation
    }
    
}
