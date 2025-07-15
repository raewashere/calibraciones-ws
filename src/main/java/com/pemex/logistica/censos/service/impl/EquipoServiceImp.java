package com.pemex.logistica.censos.service.impl;

import java.util.List;

import com.pemex.logistica.censos.entity.Equipo;
import com.pemex.logistica.censos.repository.EquipoRepository;
import com.pemex.logistica.censos.service.EquipoService;
import org.springframework.stereotype.Service;

@Service
public class EquipoServiceImp implements EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoServiceImp(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo findById(String id) {
        return equipoRepository.findById(id).orElse(null);
    }

    @Override
    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public void deleteById(String id) {
        equipoRepository.deleteById(id);
    }
    
}
