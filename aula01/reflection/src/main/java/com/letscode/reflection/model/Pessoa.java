package com.letscode.reflection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String nome;

    private List<Carro> carros;

}
