package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.pemex.logistica.censos.entity.EntidadFederativa;
import com.pemex.logistica.censos.service.EntidadFederativaService;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/entidad_federativa")
public class EntidadFederativaController {

    private final EntidadFederativaService entidadFederativaService;

    public EntidadFederativaController(EntidadFederativaService entidadFederativaService) {
        this.entidadFederativaService = entidadFederativaService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllEntidadesFederativas() {
        List<EntidadFederativa> entidades = entidadFederativaService.findAll();
        if (entidades.isEmpty()) {
            return new ResponseEntity<>("No existen entidades federativas", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntidadFederativaById(@PathVariable Long id) {
        EntidadFederativa entidad = entidadFederativaService.findById(id);
        if (entidad != null) {
            return new ResponseEntity<>(entidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la entidad federativa", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveEntidadFederativa(@RequestBody EntidadFederativa entidad) {
        EntidadFederativa savedEntidad = entidadFederativaService.save(entidad);
        if (savedEntidad != null) {
            return new ResponseEntity<>(savedEntidad, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar la entidad federativa", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntidadFederativa(@PathVariable Long id) {
        EntidadFederativa entidadFederativa = entidadFederativaService.findById(id);

        if (entidadFederativa != null) {
            entidadFederativaService.deleteById(id);
            return new ResponseEntity<>("Entidad federativa eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la entidad federativa para eliminar", HttpStatus.NOT_FOUND);
        }   
    }
    
}
