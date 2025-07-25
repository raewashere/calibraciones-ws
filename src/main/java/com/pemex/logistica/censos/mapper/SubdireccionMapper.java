package com.pemex.logistica.censos.mapper;

import com.pemex.logistica.censos.dto.SubdireccionDTO;
import com.pemex.logistica.censos.entity.Direccion;
import com.pemex.logistica.censos.entity.Subdireccion;

public class SubdireccionMapper {
    
    public static SubdireccionDTO toDTO(Subdireccion subdireccion) {
        if (subdireccion == null) {
            return null;
        }
        
        SubdireccionDTO dto = new SubdireccionDTO();
        dto.setId_subdireccion(subdireccion.getId_subdireccion());
        dto.setNombre_subdireccion(subdireccion.getNombre_subdireccion());
        dto.setId_direccion(subdireccion.getDireccion().getId_direccion());
        return dto;
    }

    public static Subdireccion toEntity(SubdireccionDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Subdireccion subdireccion = new Subdireccion();
        subdireccion.setId_subdireccion(dto.getId_subdireccion());
        subdireccion.setNombre_subdireccion(dto.getNombre_subdireccion());
        
        Direccion direccion = new Direccion();
        direccion.setId_direccion(dto.getId_direccion());
        subdireccion.setDireccion(direccion);
        
        return subdireccion;
    }
}
