package com.project.apispring.services;

import com.project.apispring.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> buscarTodosOsUsuarios();

    public Optional<Usuario> buscarUsuarioPorId(Long id);

    public Usuario salvarUsuario(Usuario usuario);

    public Usuario atualizarUsuario(Long id, Usuario usuario);

    public Usuario atualizarDadosUsuario(Long id, Usuario usuario);

    public void deletarUsuarioPorId(Long id);
}
