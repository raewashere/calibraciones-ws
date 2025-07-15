package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pemex.logistica.censos.entity.TipoSensor;
import com.pemex.logistica.censos.service.TipoSensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;



@RestController
@RequestMapping("/api/tipo_sensor")
public class TipoSensorController {
    
    private final TipoSensorService tipoSensorService;

    public TipoSensorController(TipoSensorService tipoSensorService) {
        this.tipoSensorService = tipoSensorService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllTipoSensores() {
        List<TipoSensor> tipoSensores = tipoSensorService.findAll();
        if (tipoSensores.isEmpty()) {
            return new ResponseEntity<>("No existen tipos de sensores", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tipoSensores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTipoSensorById(@PathVariable Long id) {
        TipoSensor tipoSensor = tipoSensorService.findById(id);
        if (tipoSensor != null) {
            return new ResponseEntity<>(tipoSensor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe el tipo de sensor", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveTipoSensor(@RequestBody TipoSensor tipoSensor) {
        TipoSensor savedTipoSensor = tipoSensorService.save(tipoSensor);
        if (savedTipoSensor != null) {
            return new ResponseEntity<>(savedTipoSensor, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar el tipo de sensor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTipoSensor(@PathVariable Long id) {
        TipoSensor tipoSensor = tipoSensorService.findById(id);
        if (tipoSensor != null) {
            tipoSensorService.deleteById(id);
            return new ResponseEntity<>("Tipo de sensor eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe el tipo de sensor para eliminar", HttpStatus.NOT_FOUND);
        }
    }

}
