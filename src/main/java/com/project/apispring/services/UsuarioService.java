package com.project.apispring.services;

import com.project.apispring.models.Usuario;
import com.project.apispring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodosOsUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Object buscarUsuarioPorId(Long id){
        return this.usuarioRepository.findById(id);
    }

    public void salvarUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    public void deletarUsuarioPorId(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}
