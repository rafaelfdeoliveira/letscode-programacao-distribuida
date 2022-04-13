package com.letscode.reflection.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "carro")
public class Carro {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "placa", nullable = false, unique = true)
    private String placa;

    @Column(name = "modelo", nullable = false, unique = true)
    private String modelo;

    @Column(name = "ano", nullable = false, unique = true)
    private Integer ano;

    @ManyToMany
    @JoinTable(
            name = "pessoa_carro",
            joinColumns = { @JoinColumn(name = "id_carro", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id_pessoa", referencedColumnName = "id") }
    )
    private List<Pessoa> pessoa;
}


