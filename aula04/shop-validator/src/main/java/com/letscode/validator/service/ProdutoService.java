package com.letscode.validator.service;

import com.letscode.shop.dto.ProdutoDTO;
import org.springframework.web.reactive.function.client.WebClient;

public class ProdutoService {


    public static ProdutoDTO getProduto(String identificador) {
        WebClient webClient = WebClient.create("http://localhost:8081");

        return webClient
                .get()
                .uri("/produto/{id}", identificador)
                .retrieve()
                .bodyToMono(ProdutoDTO.class)
                .block();
    }
}
