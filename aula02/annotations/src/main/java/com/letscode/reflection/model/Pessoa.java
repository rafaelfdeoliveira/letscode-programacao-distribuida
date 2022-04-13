package com.letscode.reflection.model;

import javax.persistence.*;
import java.util.List;

// create table pessoa (id integer primary key, nome varchar, cpf varchar)

@Entity(name = "pessoa_fisica")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Transient
    private Float salario;

    @OneToMany
    private List<Carro> carros;
}
