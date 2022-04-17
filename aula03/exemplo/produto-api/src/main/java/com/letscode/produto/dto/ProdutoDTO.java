package com.letscode.produto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoDTO {

    private String identifier;
    private String name;
    private Float price;

}
