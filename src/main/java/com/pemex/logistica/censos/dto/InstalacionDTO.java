package com.pemex.logistica.censos.dto;
import lombok.Data;

@Data
public class InstalacionDTO {

    private Integer id_instalacion;
    private String nombre_instalacion;
    private String region_fiscal;
    private Integer id_entidad_federativa;
    private Integer id_gerencia;
    private Integer id_subdireccion;
    
}
