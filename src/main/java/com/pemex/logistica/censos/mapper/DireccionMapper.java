package com.pemex.logistica.censos.mapper;

import com.pemex.logistica.censos.dto.DireccionDTO;
import com.pemex.logistica.censos.entity.Direccion;

public class DireccionMapper {
    
    public static DireccionDTO toDTO(Direccion direccion) {
        if (direccion == null) {
            return null;
        }
        
        DireccionDTO dto = new DireccionDTO();
        dto.setId_direccion(direccion.getId_direccion());
        dto.setNombre_direccion(direccion.getNombre_direccion());
        return dto;
    }

    public static Direccion toEntity(DireccionDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Direccion direccion = new Direccion();
        direccion.setId_direccion(dto.getId_direccion());
        direccion.setNombre_direccion(dto.getNombre_direccion());
        return direccion;
    }
}
