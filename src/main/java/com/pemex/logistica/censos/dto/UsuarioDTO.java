package com.pemex.logistica.censos.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    
    private Integer id_usuario;
    private String correo_electronico;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String telefono;
    private String rol;
    private Boolean verificacion_admin;
}
