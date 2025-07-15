package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pemex.logistica.censos.entity.Equipo;
import com.pemex.logistica.censos.service.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;



@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    
    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllEquipos() {
        List<Equipo> equipos = equipoService.findAll();
        if (equipos.isEmpty()) {
            return new ResponseEntity<>("No existen equipos", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEquipoById(@PathVariable String id) {
        Equipo equipo = equipoService.findById(id);
        if (equipo != null) {
            return new ResponseEntity<>(equipo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe el equipo", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveEquipo(@RequestBody Equipo equipo) {
        Equipo savedEquipo = equipoService.save(equipo);
        if (savedEquipo != null) {
            return new ResponseEntity<>(savedEquipo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar el equipo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEquipo(@PathVariable String id) {
        Equipo equipo = equipoService.findById(id);
        if (equipo != null) {
            equipoService.deleteById(id);
            return new ResponseEntity<>("Equipo eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe el equipo para eliminar", HttpStatus.NOT_FOUND);
        }
    }
}
