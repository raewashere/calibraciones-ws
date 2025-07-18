package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pemex.logistica.censos.entity.Instalacion;
import com.pemex.logistica.censos.service.InstalacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/instalacion")
public class InstalacionController {

    private final InstalacionService instalacionService;

    public InstalacionController(InstalacionService instalacionService) {
        this.instalacionService = instalacionService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllInstalaciones() {
        List<Instalacion> instalaciones = instalacionService.findAll();
        if (instalaciones.isEmpty()) {
            return new ResponseEntity<>("No existen instalaciones", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(instalaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstalacionById(@PathVariable Long id) {
        Instalacion instalacion = instalacionService.findById(id);
        if (instalacion != null) {
            return new ResponseEntity<>(instalacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la instalación", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveInstalacion(@RequestBody Instalacion instalacion) {
        Instalacion savedInstalacion = instalacionService.save(instalacion);
        if (savedInstalacion != null) {
            return new ResponseEntity<>(savedInstalacion, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar la instalación", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstalacion(@PathVariable Long id) {
        Instalacion instalacion = instalacionService.findById(id);
        if (instalacion != null) {
            instalacionService.deleteById(id);
            return new ResponseEntity<>("Instalación eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la instalación para eliminar", HttpStatus.NOT_FOUND);
        }
    }

}
