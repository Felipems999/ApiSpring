package com.project.apispring.services.implementations;

import com.project.apispring.models.Usuario;
import com.project.apispring.repositories.UsuarioRepository;
import com.project.apispring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
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
        Optional<Usuario> usuarioDesatualizado = this.usuarioRepository.findById(id);

        Usuario u = usuarioDesatualizado.get();
        u.setNome(usuario.getNome());
        u.setNascimento(usuario.getNascimento());
        u.setGenero(usuario.getGenero());

        return this.usuarioRepository.save(u);
    }

    @Override
    public Usuario atualizarDados(Long id, Usuario usuario) {
        Optional<Usuario> usuarioDesatualizado = this.usuarioRepository.findById(id);

        try {
            if (usuarioDesatualizado.isPresent()) {

                Usuario u = usuarioDesatualizado.get();

                if (usuario.getNome() != null && !usuario.getNome().equals(u.getNome()))
                    u.setNome(usuario.getNome());

                if (usuario.getNascimento() != null && !usuario.getNascimento().equals(u.getNascimento()))
                    u.setNascimento(usuario.getNascimento());

                if (usuario.getGenero() != null && !usuario.getGenero().equals(u.getGenero()))
                    u.setGenero(usuario.getGenero());

                return this.usuarioRepository.save(u);
            }
        }catch (Exception e) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return usuario;
    }

    public void deletarUsuarioPorId(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
