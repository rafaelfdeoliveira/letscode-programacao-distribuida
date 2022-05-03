package com.letscode.cliente.dto;

import com.letscode.cliente.model.Endereco;
import com.letscode.cliente.model.Telefone;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefoneDTO {
    private String ddd;
    private String numero;

    public static TelefoneDTO convert(Telefone telefone) {
        return TelefoneDTO
                .builder()
                .ddd(telefone.getDdd())
                .numero(telefone.getNumero())
                .build();
    }
}
