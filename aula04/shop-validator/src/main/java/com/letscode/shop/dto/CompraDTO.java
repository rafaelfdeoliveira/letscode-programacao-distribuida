package com.letscode.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CompraDTO {
    private String identificador;
    private String identificadorCliente;
    private LocalDateTime horaCompra;
    private List<String> identificadoresProdutos;
    private Float valorTotal;
    private String status;
}
