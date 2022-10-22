package com.project.apispring.controllers;

import com.project.apispring.models.Usuario;
import com.project.apispring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return this.usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuario(@PathParam("{id}") Long id){
        return this.usuarioRepository.findById(id);
    }

    @PostMapping("/usuarios")
    public Usuario postUsuario(Usuario usuario){
        this.usuarioRepository.save(usuario);
        return usuario;
    }

    @DeleteMapping("/{id}")
    public void putUsuario(@PathParam("{id}") Long id){
        this.usuarioRepository.deleteById(id);
    }

}
