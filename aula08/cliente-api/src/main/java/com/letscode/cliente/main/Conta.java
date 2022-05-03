package com.letscode.cliente.main;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class Conta implements Runnable {

    private Integer numero;
    public Integer retorno = null;
    public Conta(Integer numero) {
        this.numero = numero;
    }

    public void run() {

        Integer soma = IntStream
                .range(1, this.numero)
                .sum();
        log.info("" + soma);

        retorno = soma;
    }



}
