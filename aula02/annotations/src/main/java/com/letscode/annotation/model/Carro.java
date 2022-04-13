package com.letscode.annotation.model;

import com.letscode.annotation.annotation.JsonElement;
import com.letscode.annotation.annotation.JsonEntity;
import com.letscode.annotation.annotation.JsonInit;

@JsonEntity
public class Carro {

    @JsonElement(name = "modelo")
    private String modelo;
    @JsonElement(name = "placa")
    private String placa;
    @JsonElement(name = "ano")
    private Integer ano;
    @JsonElement(name = "rodizio")
    private String rodizio;



    public Carro(String modelo, String placa, Integer ano) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    @JsonInit
    private void initNames() {
        if (placa.endsWith("0") || placa.endsWith("1")) {
            rodizio = "segunda";
        }
        if (placa.endsWith("2") || placa.endsWith("3")) {
            rodizio = "terca";
        }
        if (placa.endsWith("4") || placa.endsWith("5")) {
            rodizio = "quarta";
        }
        if (placa.endsWith("6") || placa.endsWith("7")) {
            rodizio = "quinta";
        }
        if (placa.endsWith("8") || placa.endsWith("9")) {
            rodizio = "sexta";
        }
    }
}
