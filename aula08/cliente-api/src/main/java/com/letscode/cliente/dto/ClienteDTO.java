package com.letscode.cliente.dto;

import com.letscode.cliente.model.Cliente;
import com.letscode.cliente.model.Endereco;
import com.letscode.cliente.model.Telefone;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {
    private String id;
    private String nome;
    private String cpf;
    private Integer idade;
    private LocalDate dataNascimento;
    private EnderecoDTO endereco;
    private List<TelefoneDTO> telefone = new ArrayList<>();

    public static ClienteDTO convert(Cliente cliente) {
        return ClienteDTO
                .builder()
                .id(cliente.getId())
                .idade(cliente.getIdade())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .dataNascimento(cliente.getDataNascimento())
                .telefone(cliente.getTelefone().stream().map(TelefoneDTO::convert).collect(Collectors.toList()))
                .endereco(EnderecoDTO.convert(cliente.getEndereco()))
                .build();
    }

}
