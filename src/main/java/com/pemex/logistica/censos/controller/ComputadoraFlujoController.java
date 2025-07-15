package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pemex.logistica.censos.entity.ComputadoraFlujo;
import com.pemex.logistica.censos.service.ComputadoraFlujoService;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/computadora_flujo")
public class ComputadoraFlujoController {
    
    private final ComputadoraFlujoService computadoraFlujoService;

    public ComputadoraFlujoController(ComputadoraFlujoService computadoraFlujoService) {
        this.computadoraFlujoService = computadoraFlujoService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllComputadorasFlujo() {
        List<ComputadoraFlujo> computadoraFlujo = computadoraFlujoService.findAll();
        if (computadoraFlujo.isEmpty()) {
            return new ResponseEntity<>("No existen computadoras de flujo", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computadoraFlujo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getComputadoraFlujoById(@PathVariable String id) {
        ComputadoraFlujo computadoraFlujo = computadoraFlujoService.findById(id);
        if (computadoraFlujo != null) {
            return new ResponseEntity<>(computadoraFlujo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la computadora", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveComputadoraFlujo(@RequestBody ComputadoraFlujo computadoraFlujo) {
        ComputadoraFlujo savedComputadoraFlujo = computadoraFlujoService.save(computadoraFlujo);
        if (savedComputadoraFlujo != null) {
            return new ResponseEntity<>(savedComputadoraFlujo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar la computadora de flujo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComputadoraFlujo(@PathVariable String id) {
        ComputadoraFlujo computadoraFlujo = computadoraFlujoService.findById(id);
        if (computadoraFlujo != null) {
            computadoraFlujoService.deleteById(id);
            return new ResponseEntity<>("Computadora de flujo eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la computadora de flujo para eliminar", HttpStatus.NOT_FOUND);
        }
    }
}
