package com.letscode.cliente.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Telefone {
    private String ddd;
    private String numero;
}
