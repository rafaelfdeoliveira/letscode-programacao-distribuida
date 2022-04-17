package com.letscode.shop.service;

import com.letscode.shop.dto.ClientDTO;
import com.letscode.shop.dto.ProductDTO;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ClientService {

    public static ClientDTO getClient(String identifier) {
        WebClient client = WebClient.create("http://localhost:8082");

        return client
                .get()
                .uri("/cliente/{identifier}", identifier)
                .retrieve()
                .bodyToMono(ClientDTO.class)
                .block();
    }

}
