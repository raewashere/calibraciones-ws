package com.pemex.logistica.censos.mapper;

import com.pemex.logistica.censos.dto.UsuarioDTO;
import com.pemex.logistica.censos.entity.Usuario;

public class UsuarioMapper {
    
    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId_usuario(usuario.getId_usuario());
        dto.setCorreo_electronico(usuario.getCorreo_electronico());
        dto.setNombre(usuario.getNombre());
        dto.setPrimer_apellido(usuario.getPrimer_apellido());
        dto.setSegundo_apellido(usuario.getSegundo_apellido());
        dto.setTelefono(usuario.getTelefono());
        dto.setRol(usuario.getRol());
        dto.setVerificacion_admin(usuario.getVerificacion_admin());
        
        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setId_usuario(dto.getId_usuario());
        usuario.setCorreo_electronico(dto.getCorreo_electronico());
        usuario.setNombre(dto.getNombre());
        usuario.setPrimer_apellido(dto.getPrimer_apellido());
        usuario.setSegundo_apellido(dto.getSegundo_apellido());
        usuario.setTelefono(dto.getTelefono());
        usuario.setRol(dto.getRol());
        usuario.setVerificacion_admin(dto.getVerificacion_admin());

        return usuario;
    }
}
