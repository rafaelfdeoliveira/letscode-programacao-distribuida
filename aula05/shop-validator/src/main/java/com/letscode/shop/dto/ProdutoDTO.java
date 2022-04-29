package com.letscode.shop.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoDTO implements Serializable {
    private String identificador;
    private Float preco;
}
