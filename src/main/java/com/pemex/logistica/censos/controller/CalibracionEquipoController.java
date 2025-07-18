package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pemex.logistica.censos.entity.CalibracionEquipo;
import com.pemex.logistica.censos.service.CalibracionEquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/calibracion_equipo")
public class CalibracionEquipoController {

    private final CalibracionEquipoService calibracionEquipoService;

    public CalibracionEquipoController(CalibracionEquipoService calibracionEquipoService) {
        this.calibracionEquipoService = calibracionEquipoService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllCalibraciones() {
        List<CalibracionEquipo> calibraciones = calibracionEquipoService.findAll();
        if (calibraciones.isEmpty()) {
            return new ResponseEntity<>("No existen calibraciones", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(calibraciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCalibracionById(@PathVariable Long id) {
        CalibracionEquipo calibracion = calibracionEquipoService.findById(id);
        if (calibracion != null) {
            return new ResponseEntity<>(calibracion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la calibración", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveCalibracion(@RequestBody CalibracionEquipo calibracion) {
        CalibracionEquipo savedCalibracion = calibracionEquipoService.save(calibracion);
        if (savedCalibracion != null) {
            return new ResponseEntity<>(savedCalibracion, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar la calibración", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCalibracion(@PathVariable Long id) {
        CalibracionEquipo calibracion = calibracionEquipoService.findById(id);
        if (calibracion != null) {
            calibracionEquipoService.deleteById(id);
            return new ResponseEntity<>("Calibración eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la calibración para eliminar", HttpStatus.NOT_FOUND);
        }
    }
}
