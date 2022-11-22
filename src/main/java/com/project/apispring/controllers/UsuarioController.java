package com.project.apispring.controllers;

import com.project.apispring.exceptions.UsuarioNotNullException;
import com.project.apispring.exceptions.UsuarioNullException;
import com.project.apispring.models.Usuario;
import com.project.apispring.repositories.UsuarioRepository;
import com.project.apispring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios(){
        return this.usuarioService.buscarTodosOsUsuarios();
    }

    @GetMapping("/usuario/{id}")
    public Object getUsuario(@PathVariable("id") Long id){
        return this.usuarioService.buscarUsuarioPorId(id);
    }

    @PostMapping("/novousuario")
    public Usuario postUsuario(@RequestBody Usuario usuario){
        this.usuarioService.salvarUsuario(usuario);
        return usuario;
    }

    @PutMapping("atualiza/{id}")
    public Usuario putUsuario(@RequestBody Usuario usuario, @PathVariable("id") Long id){

        return usuario;
    }

    @PatchMapping("/patch")
    public Usuario patchUsuario(){
        return new Usuario();
    }


    @DeleteMapping("/deletar/{id}")
    public void deleteUsuario(@PathVariable("id") Long id){

        if(this.usuarioService.buscarUsuarioPorId(id) == null)
            throw new UsuarioNullException();

        this.usuarioService.deletarUsuarioPorId(id);
    }

}
