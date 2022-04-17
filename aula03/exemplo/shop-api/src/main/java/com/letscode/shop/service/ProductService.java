package com.letscode.shop.service;

import com.letscode.shop.dto.ProductDTO;
import org.springframework.web.reactive.function.client.WebClient;

public class ProductService {

    public static ProductDTO getProduct(String identifier) {
        WebClient client = WebClient.create("http://localhost:8081");

        return client
                .get()
                .uri("/product/{identifier}", identifier)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }

}
