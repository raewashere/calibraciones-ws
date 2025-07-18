package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pemex.logistica.censos.entity.LaboratorioCalibracion;
import com.pemex.logistica.censos.service.LaboratorioCalibracionService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/laboratorio_calibracion")
public class LaboratorioCalibracionController {

    private final LaboratorioCalibracionService laboratorioCalibracionService;

    public LaboratorioCalibracionController(LaboratorioCalibracionService laboratorioCalibracionService) {
        this.laboratorioCalibracionService = laboratorioCalibracionService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllLaboratorios() {
        List<LaboratorioCalibracion> laboratorios = laboratorioCalibracionService.findAll();
        if (laboratorios.isEmpty()) {
            return new ResponseEntity<>("No existen laboratorios de calibración", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(laboratorios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLaboratorioById(@PathVariable Long id) {
        LaboratorioCalibracion laboratorio = laboratorioCalibracionService.findById(id);
        if (laboratorio != null) {
            return new ResponseEntity<>(laboratorio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe el laboratorio de calibración", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveLaboratorio(@RequestBody LaboratorioCalibracion laboratorio) {
        LaboratorioCalibracion savedLaboratorio = laboratorioCalibracionService.save(laboratorio);
        if (savedLaboratorio != null) {
            return new ResponseEntity<>(savedLaboratorio, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar el laboratorio de calibración",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLaboratorio(@PathVariable Long id) {
        LaboratorioCalibracion laboratorio = laboratorioCalibracionService.findById(id);
        if (laboratorio != null) {
            laboratorioCalibracionService.deleteById(id);
            return new ResponseEntity<>("Laboratorio de calibración eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe el laboratorio de calibración para eliminar", HttpStatus.NOT_FOUND);
        }
    }

}
