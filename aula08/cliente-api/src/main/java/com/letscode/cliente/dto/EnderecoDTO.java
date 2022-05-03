package com.letscode.cliente.dto;

import com.letscode.cliente.model.Cliente;
import com.letscode.cliente.model.Endereco;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoDTO {
    private String logradouro;
    private Integer numero;
    private String cidade;

    public static EnderecoDTO convert(Endereco endereco) {
        return EnderecoDTO
                .builder()
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .cidade(endereco.getCidade())
                .build();
    }
}
