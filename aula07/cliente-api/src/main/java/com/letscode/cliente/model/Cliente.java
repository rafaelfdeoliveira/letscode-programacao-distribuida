package com.letscode.cliente.model;

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
public class Cliente {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private Integer idade;
    private LocalDate dataNascimento;
    private List<Telefone> telefone = new ArrayList<>();
    private Endereco endereco;
}
