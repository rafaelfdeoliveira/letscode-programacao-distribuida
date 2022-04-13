package com.letscode.annotation.model;

import com.letscode.annotation.annotation.JsonElement;
import com.letscode.annotation.annotation.JsonEntity;
import com.letscode.annotation.annotation.JsonInit;
import com.letscode.annotation.annotation.JsonList;

import java.util.List;

@JsonEntity
public class Pessoa {

    @JsonElement(name = "nome")
    private String nome;
    @JsonElement(name = "sobrenome")
    private String sobrenome;
    @JsonElement(name = "endereco")
    private String endereco;
    @JsonElement(name = "idade")
    private Integer idade;
    @JsonElement(name = "nome_completo")
    private String nomeCompleto;

    @JsonList(name = "telefones")
    private List<String> telefones;

    public Pessoa(String nome, String sobrenome, String endereco, Integer idade, List<String> telefones) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.idade = idade;
        this.telefones = telefones;
    }

    @JsonInit
    private void initNames() {
        this.nomeCompleto = nome + " " + sobrenome;
    }
}
