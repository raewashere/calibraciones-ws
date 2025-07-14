package com.pemex.logistica.censos.service.impl;

import java.util.List;
import com.pemex.logistica.censos.entity.Usuario;
import com.pemex.logistica.censos.repository.UsuarioRepository;
import com.pemex.logistica.censos.service.UsuarioService;


public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
    
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario); // Replace with actual implementation
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id); // Replace with actual implementation
    }
}
