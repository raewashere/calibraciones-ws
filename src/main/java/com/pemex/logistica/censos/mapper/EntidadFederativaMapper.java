package com.pemex.logistica.censos.mapper;

import com.pemex.logistica.censos.dto.EntidadFederativaDTO;
import com.pemex.logistica.censos.entity.EntidadFederativa;

public class EntidadFederativaMapper {
    
    public static EntidadFederativaDTO toDTO(EntidadFederativa entidad) {
        if (entidad == null) {
            return null;
        }
        
        EntidadFederativaDTO dto = new EntidadFederativaDTO();
        dto.setId_entidad_federativa(entidad.getId_entidad_federativa());
        dto.setNombre_entidad_federativa(entidad.getNombre_entidad_federativa());
        return dto;
    }

    public static EntidadFederativa toEntity(EntidadFederativaDTO dto) {
        if (dto == null) {
            return null;
        }
        
        EntidadFederativa entidad = new EntidadFederativa();
        entidad.setId_entidad_federativa(dto.getId_entidad_federativa());
        entidad.setNombre_entidad_federativa(dto.getNombre_entidad_federativa());
        return entidad;
    }
}
