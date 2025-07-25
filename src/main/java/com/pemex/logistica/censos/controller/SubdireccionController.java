package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pemex.logistica.censos.dto.SubdireccionDTO;
import com.pemex.logistica.censos.entity.Direccion;
import com.pemex.logistica.censos.entity.Subdireccion;
import com.pemex.logistica.censos.service.SubdireccionService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/subdireccion")
public class SubdireccionController {

    private final SubdireccionService subdireccionService;

    public SubdireccionController(SubdireccionService subdireccionService) {
        this.subdireccionService = subdireccionService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllSubdirecciones() {
        List<Subdireccion> subdirecciones = subdireccionService.findAll();
        if (subdirecciones.isEmpty()) {
            return new ResponseEntity<>("No existen subdirecciones", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subdirecciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubdireccionById(@PathVariable Long id) {
        Subdireccion subdireccion = subdireccionService.findById(id);
        if (subdireccion != null) {
            return new ResponseEntity<>(subdireccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la subdireccion", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveSubdireccion(@RequestBody SubdireccionDTO subdireccionDTO) {
        try {
            // Crear Subdireccion a partir del DTO
            Subdireccion subdireccion = new Subdireccion();
            subdireccion.setNombre_subdireccion(subdireccionDTO.getNombre_subdireccion());

            // Asociar la dirección por ID (sin necesidad de buscar en la BD si ya sabes que
            // existe)
            Direccion direccion = new Direccion();
            direccion.setId_direccion(subdireccionDTO.getId_direccion());
            subdireccion.setDireccion(direccion);

            // Guardar usando el servicio
            Subdireccion saved = subdireccionService.save(subdireccion);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Error al guardar la subdirección: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubdireccion(@PathVariable Long id) {
        Subdireccion subdireccion = subdireccionService.findById(id);
        if (subdireccion != null) {
            subdireccionService.deleteById(id);
            return new ResponseEntity<>("Subdireccion eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la subdireccion para eliminar", HttpStatus.NOT_FOUND);
        }

    }

}
