package com.letscode.cliente.main;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Long inicio = System.currentTimeMillis();
        log.info("iniciando processamento");

        Thread conta1 = new Thread(new Conta(1000));
        log.info(conta1.getState().name());

        conta1.start();
        conta1.join();
        log.info(conta1.getState().name());

        Thread conta2 = new Thread(new Conta(100000000));
        conta2.start();

        log.info(conta1.getState().name());

        log.info("finalizando processamento");
        Long fim = System.currentTimeMillis();
        System.out.println(fim - inicio);

    }


}
