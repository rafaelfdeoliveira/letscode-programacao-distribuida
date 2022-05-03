package com.letscode.cliente.controller;

import ch.qos.logback.core.net.server.Client;
import com.letscode.cliente.dto.ClienteDTO;
import com.letscode.cliente.model.Cliente;
import com.letscode.cliente.repository.ClienteRepository;
import com.letscode.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

@RestController
        @RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public Page<ClienteDTO> listClientes(Pageable pageable) {
        return clienteService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ClienteDTO getCliente(@PathVariable String id) {
        return clienteService.findById(id);
    }

    @GetMapping("/nome")
    public Page<ClienteDTO> getClientesPorNome(ClienteDTO cliente, Pageable pageable) {
        return clienteService.listClientes(cliente, pageable);
    }

    @PostMapping
    public Cliente saveCliente(@RequestBody ClienteDTO dto) {
        return clienteService.save(dto);
    }

    @GetMapping("/teste/{numero}")
    @SneakyThrows
    public String teste(@PathVariable Integer numero) {

        clienteService.conta(numero);

        return "As imagens estao sendo processados!";
    }

}
