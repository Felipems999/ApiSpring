package com.project.apispring.controllers;

import com.project.apispring.exceptions.UsuarioNullException;
import com.project.apispring.models.Usuario;
import com.project.apispring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Optional<Usuario> getUsuario(@PathVariable("id") Long id){
        return this.usuarioService.buscarUsuarioPorId(id);
    }

    @PostMapping("/novousuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario postUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/atualiza/{id}")
    public Usuario putUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
       return this.usuarioService.atualizarUsuario(id, usuario);
    }

    @PatchMapping("/atualizardados/{id}")
    public Usuario patchUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        return this.usuarioService.atualizarDados(id, usuario);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteUsuario(@PathVariable("id") Long id){

        if(this.usuarioService.buscarUsuarioPorId(id).isEmpty())
            throw new UsuarioNullException();

        this.usuarioService.deletarUsuarioPorId(id);
    }

}
