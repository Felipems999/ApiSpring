package com.project.apispring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "usuario")
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_usuario")
    private Long id;
    @Column(nullable = false, name = "nome_usuario")
    private String nome;
    @Column(nullable = false, name = "nasc_usuario")
    private String nascimento;
    @Column(name = "genero_usuario")
    private String genero;

    public Usuario(){

    }

}
