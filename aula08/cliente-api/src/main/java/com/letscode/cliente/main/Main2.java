package com.letscode.cliente.main;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main2 {

    public static Integer saldo = 0;


    public static void main(String[] args) {

        Operacoes operacoes = new Operacoes();

        new Thread(() -> {
            operacoes.deposita();

        }).start();

        new Thread(() -> {

            operacoes.saque();


        }).start();

    }

}
