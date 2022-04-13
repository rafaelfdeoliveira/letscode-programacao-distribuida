package com.letscode.reflection.model;

import javax.persistence.*;

@Entity(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private Integer numero;

    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    private Pessoa pessoa;
}
