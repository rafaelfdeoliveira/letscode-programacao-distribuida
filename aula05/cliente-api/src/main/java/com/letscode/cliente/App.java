package com.letscode.cliente;


import com.letscode.cliente.dto.ClienteDTO;
import com.letscode.cliente.repository.ClienteRepository;
import com.letscode.cliente.service.ClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ClienteRepository clienteRepository) {
        return args -> {
            clienteRepository.save(new ClienteDTO());
        };
    }

}
