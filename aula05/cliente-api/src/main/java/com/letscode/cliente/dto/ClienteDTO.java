package com.letscode.cliente.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "cliente")
public class ClienteDTO {
    @Id
    private String id;

    private String identifier;
    private String nome;
    private String cpf;
    private Integer idade;
    private LocalDate dataNascimento;
    private List<String> telefones = new ArrayList<>();
}
