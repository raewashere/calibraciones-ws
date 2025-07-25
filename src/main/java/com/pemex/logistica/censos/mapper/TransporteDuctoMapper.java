package com.pemex.logistica.censos.mapper;

import com.pemex.logistica.censos.dto.TransporteDuctoDTO;
import com.pemex.logistica.censos.entity.TransporteDucto;

public class TransporteDuctoMapper {

    public static TransporteDuctoDTO toDTO(TransporteDucto entity) {
        TransporteDuctoDTO dto = new TransporteDuctoDTO();
        dto.setId_transporte_ducto(entity.getId_transporte_ducto());
        dto.setNombre_transporte_ducto(entity.getNombre());
        // Map other fields as needed
        return dto;
    }

    public static TransporteDucto toEntity(TransporteDuctoDTO dto) {
        TransporteDucto entity = new TransporteDucto();
        entity.setId_transporte_ducto(dto.getId_transporte_ducto());
        entity.setNombre(dto.getNombre_transporte_ducto());
        // Map other fields as needed
        return entity;
    }

}
