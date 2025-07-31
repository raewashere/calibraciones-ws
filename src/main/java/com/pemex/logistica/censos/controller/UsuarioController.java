package com.pemex.logistica.censos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pemex.logistica.censos.dto.MensajeDTO;
import com.pemex.logistica.censos.dto.UsuarioDTO;
import com.pemex.logistica.censos.entity.Usuario;
import com.pemex.logistica.censos.mapper.UsuarioMapper;
import com.pemex.logistica.censos.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.findAll().stream()
                .map(UsuarioMapper::toDTO)
                .toList();

        if (usuarios.isEmpty()) {
            return new ResponseEntity<>("No existen usuarios", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable Long id) {
        UsuarioDTO usuario = UsuarioMapper.toDTO(usuarioService.findById(id));
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe el usuario", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveUsuario(@RequestBody UsuarioDTO dto) {
        if (dto == null) {
            return new ResponseEntity<>("Datos de usuario inválidos", HttpStatus.BAD_REQUEST);
        }
        if (dto.getCorreo_electronico() == null || dto.getNombre() == null) {
            return new ResponseEntity<>("Correo electrónico y nombre son obligatorios", HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.existsByCorreoElectronico(dto.getCorreo_electronico())) {
            return new ResponseEntity<>("El correo electrónico ya está en uso", HttpStatus.CONFLICT);
        }
        if (dto.getRol() == null) {
            dto.setRol("usuario"); // Asignar rol por defecto si no se proporciona
        }
        Usuario usuario = UsuarioMapper.toEntity(dto);
        Usuario savedUsuario = usuarioService.save(usuario);
        if (savedUsuario != null) {
            return new ResponseEntity<>(UsuarioMapper.toDTO(savedUsuario), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            usuarioService.deleteById(id);
            return new ResponseEntity<>("Usuario eliminado con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe el usuario para eliminar", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/verificacion/{id}")
    public ResponseEntity<?> verificaUsuarioAdmin(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>("Datos de usuario inválidos", HttpStatus.BAD_REQUEST);
        }
        boolean verificado = usuarioService.verificaUsuarioAdmin(id);
        if (!verificado) {
            return new ResponseEntity<>(new MensajeDTO("El usuario no se verificó"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new MensajeDTO("El usuario se verificó correctamente"), HttpStatus.OK);
    }
}
