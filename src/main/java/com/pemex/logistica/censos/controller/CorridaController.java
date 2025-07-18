package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pemex.logistica.censos.entity.Corrida;
import com.pemex.logistica.censos.service.CorridaService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/corrida")
public class CorridaController {

    private final CorridaService corridaService;

    public CorridaController(CorridaService corridaService) {
        this.corridaService = corridaService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllCorridas() {
        List<Corrida> corridas = corridaService.findAll();
        if (corridas.isEmpty()) {
            return new ResponseEntity<>("No existen corridas", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(corridas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCorridaById(@PathVariable Long id) {
        Corrida corrida = corridaService.findById(id);
        if (corrida != null) {
            return new ResponseEntity<>(corrida, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la corrida", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveCorrida(@RequestBody Corrida corrida) {
        Corrida savedCorrida = corridaService.save(corrida);
        if (savedCorrida != null) {
            return new ResponseEntity<>(savedCorrida, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar la corrida", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCorrida(@PathVariable Long id) {
        Corrida corrida = corridaService.findById(id);
        if (corrida != null) {
            corridaService.deleteById(id);
            return new ResponseEntity<>("Corrida eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la corrida para eliminar", HttpStatus.NOT_FOUND);
        }
    }
}
