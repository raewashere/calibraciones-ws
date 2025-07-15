package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pemex.logistica.censos.entity.TransporteDucto;
import com.pemex.logistica.censos.service.TransporteDuctoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
@RequestMapping("/api/transporte_ducto")
public class TransporteDuctoController {

    private final TransporteDuctoService transporteDuctoService;

    public TransporteDuctoController(TransporteDuctoService transporteDuctoService) {
        this.transporteDuctoService = transporteDuctoService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllTransportesDucto() {
        List<TransporteDucto> transportesDucto = transporteDuctoService.findAll();
        if (transportesDucto.isEmpty()) {
            return new ResponseEntity<>("No existen transportes por ducto", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transportesDucto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransporteDuctoById(@RequestParam Long id) {
        TransporteDucto transporteDucto = transporteDuctoService.findById(id);
        if (transporteDucto != null) {
            return new ResponseEntity<>(transporteDucto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe el transporte por ducto", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveTransporteDucto(@RequestBody TransporteDucto transporteDucto) {
        TransporteDucto savedTransporteDucto = transporteDuctoService.save(transporteDucto);
        if (savedTransporteDucto != null) {
            return new ResponseEntity<>(savedTransporteDucto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar el transporte por ducto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransporteDucto(@RequestParam Long id) {
        TransporteDucto transporteDucto = transporteDuctoService.findById(id);
        if (transporteDucto != null) {
            transporteDuctoService.deleteById(id);
            return new ResponseEntity<>("Transporte por ducto eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe el transporte por ducto para eliminar", HttpStatus.NOT_FOUND);
        }
    }
    
}
