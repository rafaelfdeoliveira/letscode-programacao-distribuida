package com.letscode.cliente.future;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> conta(1000));

        Integer valor = future.getNow(100);
        System.out.println(valor);
    }


    @SneakyThrows
    public static Integer conta(Integer numero) {
        Integer soma = IntStream
                .range(1, numero)
                .sum();

        Thread.sleep(5000);
        return soma;
    }

}
