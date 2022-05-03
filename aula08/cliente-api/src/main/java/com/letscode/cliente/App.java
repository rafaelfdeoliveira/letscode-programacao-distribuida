package com.letscode.cliente;


import com.letscode.cliente.service.ClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

/*
    @Bean
    public CommandLineRunner commandLineRunner(ClienteService clienteService) {

        return args -> {
            Future<Integer> valor = clienteService.conta(1000);

            while (!valor.isDone()) {
                System.out.println("Ainda nao terminou!");
            }
            System.out.println(valor.get());

        };

    } */

}
