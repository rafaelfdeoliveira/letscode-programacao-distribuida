package com.letscode.cliente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letscode.cliente.dto.ClienteDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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

    @JsonIgnore
    @Transient
    private Telefone telefoneQuery;

    public static Cliente convert(ClienteDTO dto) {
        return Cliente
                .builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .idade(dto.getIdade())
                .build();
    }

}
