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

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> getUsuario(@PathVariable("id") Long id){
        return this.usuarioRepository.findById(id);
    }

    @PostMapping("/usuarios")
    public Usuario postUsuario(@RequestBody Usuario usuario){
        this.usuarioRepository.save(usuario);
        return usuario;
    }

    @PostMapping("/{usuario}")
    public void putUsuario(@PathVariable("id") Long id){
        for(Usuario u : this.usuarioRepository.findAll()) {
            if (u.getId().equals(id)) {
                this.usuarioRepository.deleteById(id);
            }
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable("id") Long id){
        this.usuarioRepository.deleteById(id);
    }

}
