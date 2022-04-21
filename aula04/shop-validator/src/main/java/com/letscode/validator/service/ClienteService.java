package com.letscode.validator.service;

import com.letscode.shop.dto.ClienteDTO;
import org.springframework.web.reactive.function.client.WebClient;

public class ClienteService {

    public static ClienteDTO getClient(String identificador) {
        WebClient webClient = WebClient.create("http://localhost:8082");

        return webClient
                .get()
                .uri("/cliente/{id}", identificador)
                .retrieve()
                .bodyToMono(ClienteDTO.class)
                .block();
    }

}
