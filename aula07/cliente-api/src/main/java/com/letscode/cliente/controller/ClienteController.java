package com.letscode.cliente.controller;

import ch.qos.logback.core.net.server.Client;
import com.letscode.cliente.dto.ClienteDTO;
import com.letscode.cliente.model.Cliente;
import com.letscode.cliente.repository.ClienteRepository;
import com.letscode.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    @GetMapping
    public Page<Cliente> listClientes(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable String id) {
        return clienteRepository.findById(id).get();
    }

    @GetMapping("/nome")
    public Page<Cliente> getClientesPorNome(Cliente cliente, Pageable pageable) {
        return clienteService.listClientes(cliente, pageable);
    }

    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        cliente.setId(UUID.randomUUID().toString());
        return clienteRepository.save(cliente);
    }

}
