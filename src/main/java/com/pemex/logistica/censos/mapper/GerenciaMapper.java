package com.pemex.logistica.censos.mapper;

import com.pemex.logistica.censos.dto.GerenciaDTO;
import com.pemex.logistica.censos.entity.Gerencia;
import com.pemex.logistica.censos.entity.Subdireccion;

public class GerenciaMapper {

    public static GerenciaDTO toDTO(Gerencia gerencia) {
        if (gerencia == null) {
            return null;
        }

        GerenciaDTO dto = new GerenciaDTO();
        dto.setId_gerencia(gerencia.getId_gerencia());
        dto.setNombre_gerencia(gerencia.getNombre_gerencia());
        dto.setId_subdireccion(
                gerencia.getSubdireccion() != null ? gerencia.getSubdireccion().getId_subdireccion() : null);
        return dto;
    }

    public static Gerencia toEntity(GerenciaDTO dto) {
        if (dto == null) {
            return null;
        }

        Gerencia gerencia = new Gerencia();
        gerencia.setId_gerencia(dto.getId_gerencia());
        gerencia.setNombre_gerencia(dto.getNombre_gerencia());

        if (dto.getId_subdireccion() != null) {
            Subdireccion subdireccion = new Subdireccion();
            subdireccion.setId_subdireccion(dto.getId_subdireccion());
            gerencia.setSubdireccion(subdireccion);

        }

        return gerencia;
    }

}
