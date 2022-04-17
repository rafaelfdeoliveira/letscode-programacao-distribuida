package com.letscode.cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientDTO {
    private String identifier;
    private String cpf;
    private String name;
}
