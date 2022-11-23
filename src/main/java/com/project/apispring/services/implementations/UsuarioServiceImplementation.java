package com.project.apispring.services.implementations;

import com.project.apispring.models.Usuario;
import com.project.apispring.repositories.UsuarioRepository;
import com.project.apispring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodosOsUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id){
        return this.usuarioRepository.findById(id);
    }

    public Usuario salvarUsuario(Usuario usuario) {
       return this.usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario){
        if(this.usuarioRepository.existsById(id)){
            this.usuarioRepository.deleteById(id);
            return this.usuarioRepository.save(usuario);
        }
        return this.usuarioRepository.save(usuario);
    }

    public Usuario atualizarDadosUsuario(Long id, Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    public void deletarUsuarioPorId(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}
