package com.project.apispring.controllers.controlleradvices;

import com.project.apispring.exceptions.UsuarioNotNullException;
import com.project.apispring.exceptions.UsuarioNullException;
import com.project.apispring.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UsuarioControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsuarioNullException.class)
    public ResponseEntity<Object> usuarioNaoEncontrado(){

        Map<String, Object> body = new HashMap<>();

        body.put("Mensagem", "Não foi encontrado o produto com a chave informada!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(UsuarioNotNullException.class)
    public ResponseEntity<Object> valorNull(){
        Map<String, Object> body = new HashMap<>();

        body.put("Mensagem", "Algum valor obrigatório não foi informado");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
