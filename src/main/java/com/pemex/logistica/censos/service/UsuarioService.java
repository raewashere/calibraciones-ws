package com.pemex.logistica.censos.service;

import java.util.List;

import com.pemex.logistica.censos.entity.Usuario;

public interface UsuarioService {

    List<Usuario> findAll();

    Usuario findById(Long id);

    Usuario save(Usuario usuario);

    void deleteById(Long id);
}
