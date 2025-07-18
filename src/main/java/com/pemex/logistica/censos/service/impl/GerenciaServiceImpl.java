package com.pemex.logistica.censos.service.impl;

import java.util.List;

import com.pemex.logistica.censos.entity.Gerencia;
import com.pemex.logistica.censos.repository.GerenciaRepository;
import com.pemex.logistica.censos.service.GerenciaService;
import org.springframework.stereotype.Service;

@Service
public class GerenciaServiceImpl implements GerenciaService {

    private final GerenciaRepository gerenciaRepository;

    public GerenciaServiceImpl(GerenciaRepository gerenciaRepository) {
        this.gerenciaRepository = gerenciaRepository;
    }

    // Implement methods defined in GerenciaService interface
    @Override
    public List<Gerencia> findAll() {
        // Implementation logic here
        return gerenciaRepository.findAll(); // Replace with actual implementation
    }

    @Override
    public Gerencia findById(Long id) {
        // Implementation logic here
        return gerenciaRepository.findById(id).orElse(null); // Replace with actual implementation
    }

    @Override
    public Gerencia save(Gerencia gerencia) {
        // Implementation logic here
        return gerenciaRepository.save(gerencia); // Replace with actual implementation
    }

    @Override
    public void deleteById(Long id) {
        gerenciaRepository.deleteById(id); // Replace with actual implementation
    }

}
