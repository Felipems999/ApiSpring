package com.project.apispring.services;

import com.project.apispring.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService extends Service{
    List<Usuario> buscarTodosOsUsuarios();

    public Optional<Usuario> buscarUsuarioPorId(Long id);

    public Usuario salvarUsuario(Usuario usuario);

    public Usuario atualizarUsuario(Long id, Usuario usuario);

    public Usuario atualizarDadosUsuario(Long id, Usuario usuario);

    public void deletarUsuarioPorId(Long id);
}
