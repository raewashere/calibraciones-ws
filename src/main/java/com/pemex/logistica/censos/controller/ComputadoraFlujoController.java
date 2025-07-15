package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pemex.logistica.censos.entity.ComputadoraFlujo;
import com.pemex.logistica.censos.service.ComputadoraFlujoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/computadora_flujo")
public class ComputadoraFlujoController {
    
    private final ComputadoraFlujoService computadoraFlujoService;

    public ComputadoraFlujoController(ComputadoraFlujoService computadoraFlujoService) {
        this.computadoraFlujoService = computadoraFlujoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getComputadoraFlujoById(@RequestParam String id) {
        ComputadoraFlujo computadoraFlujo = computadoraFlujoService.findById(id);
        if (computadoraFlujo != null) {
            return new ResponseEntity<>(computadoraFlujo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la computadora de flujo", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteComputadoraFlujo(@RequestParam String id) {
        ComputadoraFlujo computadoraFlujo = computadoraFlujoService.findById(id);
        if (computadoraFlujo != null) {
            computadoraFlujoService.deleteById(id);
            return new ResponseEntity<>("Computadora de flujo eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la computadora de flujo para eliminar", HttpStatus.NOT_FOUND);
        }
    }
}
