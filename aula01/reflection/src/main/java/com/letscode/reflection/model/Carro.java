package com.letscode.reflection.model;

import javax.persistence.*;

@Entity
public class Carro {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
}
