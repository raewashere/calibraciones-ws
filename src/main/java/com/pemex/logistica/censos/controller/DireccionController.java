package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pemex.logistica.censos.entity.Direccion;
import com.pemex.logistica.censos.service.DireccionService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/direccion")
public class DireccionController {

    private final DireccionService direccionService;


    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping
    public ResponseEntity<?> getAllDirecciones() {

        List<Direccion> direcciones = direccionService.findAll();
        if (direcciones.isEmpty()) {
            return new ResponseEntity<>("No existen direcciones", HttpStatus.NOT_FOUND);
        }   
        return new ResponseEntity<>(direcciones, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDireccionById(@PathVariable Long id) {

        Direccion direccion = direccionService.findById(id);
        if (direccion != null) {
            return new ResponseEntity<>(direccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la direccion", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveDireccion(@RequestBody Direccion direccion) {
        Direccion savedDireccion = direccionService.save(direccion);
        if (savedDireccion != null) {
            return new ResponseEntity<>(savedDireccion, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar la direccion", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDireccion(@PathVariable Long id) {
        Direccion direccion = direccionService.findById(id);
        if (direccion != null) {
            direccionService.deleteById(id);
            return new ResponseEntity<>("Direccion eliminada con exito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la direccion", HttpStatus.NOT_FOUND);
        }
    }
    

    
    
    
}
