package com.pemex.logistica.censos.mapper;

import com.pemex.logistica.censos.dto.SubdireccionLogisticaDTO;
import com.pemex.logistica.censos.entity.Direccion;
import com.pemex.logistica.censos.entity.SubdireccionLogistica;

public class SubdireccionLogisticaMapper {
    
    public static SubdireccionLogisticaDTO toDTO(SubdireccionLogistica subdireccion) {
        if (subdireccion == null) {
            return null;
        }
        
        SubdireccionLogisticaDTO dto = new SubdireccionLogisticaDTO();
        dto.setId_subdireccion(subdireccion.getId_subdireccion());
        dto.setNombre_subdireccion(subdireccion.getNombre_subdireccion());
        dto.setId_direccion(subdireccion.getDireccion().getId_direccion());
        return dto;
    }

    public static SubdireccionLogistica toEntity(SubdireccionLogisticaDTO dto) {
        if (dto == null) {
            return null;
        }
        
        SubdireccionLogistica subdireccion = new SubdireccionLogistica();
        subdireccion.setId_subdireccion(dto.getId_subdireccion());
        subdireccion.setNombre_subdireccion(dto.getNombre_subdireccion());
        
        Direccion direccion = new Direccion();
        direccion.setId_direccion(dto.getId_direccion());
        subdireccion.setDireccion(direccion);
        
        return subdireccion;
    }
    
}
