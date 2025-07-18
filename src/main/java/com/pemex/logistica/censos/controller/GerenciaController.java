package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pemex.logistica.censos.entity.Gerencia;
import com.pemex.logistica.censos.service.GerenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/gerencia")
public class GerenciaController {

    private final GerenciaService gerenciaService;

    public GerenciaController(GerenciaService gerenciaService) {
        this.gerenciaService = gerenciaService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllGerencias() {
        List<Gerencia> gerencias = gerenciaService.findAll();
        if (gerencias.isEmpty()) {
            return new ResponseEntity<>("No existen gerencias", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gerencias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGerenciaById(@PathVariable Long id) {
        Gerencia gerencia = gerenciaService.findById(id);
        if (gerencia != null) {
            return new ResponseEntity<>(gerencia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la gerencia", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveGerencia(@RequestBody Gerencia gerencia) {
        Gerencia savedGerencia = gerenciaService.save(gerencia);
        if (savedGerencia != null) {
            return new ResponseEntity<>(savedGerencia, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar la gerencia", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGerencia(@PathVariable Long id) {
        Gerencia gerencia = gerenciaService.findById(id);
        if (gerencia != null) {
            gerenciaService.deleteById(id);
            return new ResponseEntity<>("Gerencia eliminada con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la gerencia para eliminar", HttpStatus.NOT_FOUND);
        }
    }

}
