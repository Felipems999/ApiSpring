package com.project.apispring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String nascimento;
    @Column
    private String genero;

    public Usuario(){

    }

}
