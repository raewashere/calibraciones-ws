package com.pemex.logistica.censos.service.impl;

import java.util.List;
import com.pemex.logistica.censos.entity.LaboratorioCalibracion;
import com.pemex.logistica.censos.repository.LaboratorioCalibracionRepository;
import com.pemex.logistica.censos.service.LaboratorioCalibracionService;
import org.springframework.stereotype.Service;

@Service
public class LaboratorioCalibracionServiceImp implements LaboratorioCalibracionService {

    private final LaboratorioCalibracionRepository laboratorioCalibracionRepository;

    public LaboratorioCalibracionServiceImp(LaboratorioCalibracionRepository laboratorioCalibracionRepository) {
        this.laboratorioCalibracionRepository = laboratorioCalibracionRepository;
    }

    @Override
    public List<LaboratorioCalibracion> findAll() {
        return laboratorioCalibracionRepository.findAll();
    }

    @Override
    public LaboratorioCalibracion findById(Long id) {
        return laboratorioCalibracionRepository.findById(id).orElse(null);
    }

    @Override
    public LaboratorioCalibracion save(LaboratorioCalibracion laboratorioCalibracion) {
        return laboratorioCalibracionRepository.save(laboratorioCalibracion); // Replace with actual implementation
    }

    @Override
    public void deleteById(Long id) {
        laboratorioCalibracionRepository.deleteById(id); // Replace with actual implementation
    }
    

}
