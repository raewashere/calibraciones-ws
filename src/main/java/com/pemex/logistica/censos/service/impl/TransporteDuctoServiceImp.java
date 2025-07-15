package com.pemex.logistica.censos.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pemex.logistica.censos.entity.TransporteDucto;
import com.pemex.logistica.censos.repository.TransporteDuctoRepository;
import com.pemex.logistica.censos.service.TransporteDuctoService;
import org.springframework.stereotype.Service;

@Service
public class TransporteDuctoServiceImp implements TransporteDuctoService {
    // Assuming you have a repository for TransporteDucto
    private final TransporteDuctoRepository transporteDuctoRepository;

    public TransporteDuctoServiceImp(TransporteDuctoRepository transporteDuctoRepository) {
        this.transporteDuctoRepository = transporteDuctoRepository;
    }

    @Override
    public List<TransporteDucto> findAll() {
        return transporteDuctoRepository.findAll(); // Replace with actual implementation
    }

    @Override
    public TransporteDucto findById(Long id) {
        return transporteDuctoRepository.findById(id).orElse(null); // Replace with actual implementation
    }

    @Override
    public TransporteDucto save(TransporteDucto transporteDucto) {
        return transporteDuctoRepository.save(transporteDucto); // Replace with actual implementation
    }

    @Override
    public void deleteById(Long id) {
        transporteDuctoRepository.deleteById(id); // Replace with actual implementation
    }
    
}
