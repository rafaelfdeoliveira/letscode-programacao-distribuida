package com.letscode.cliente.main;

public class Operacoes {

    public synchronized void deposita() {
        System.out.println("valor antes: {} " + Main2.saldo);
        Integer valor = Main2.saldo;
        valor += 10;
        Main2.saldo = valor;
        System.out.println("valor depois: {} " + Main2.saldo);
    }

    public synchronized void saque() {
        System.out.println("valor antes: {} " + Main2.saldo);
        Integer valor = Main2.saldo;
        valor -= 10;
        Main2.saldo = valor;
        System.out.println("valor depois: {} " + Main2.saldo);
    }

}
