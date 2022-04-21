package com.letscode.produto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoDTO {
    private String identificador;
    private String nome;
    private Float preco;
}
