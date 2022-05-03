package com.letscode.cliente.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {
    private String logradouro;
    private Integer numero;
    private String cidade;
}
