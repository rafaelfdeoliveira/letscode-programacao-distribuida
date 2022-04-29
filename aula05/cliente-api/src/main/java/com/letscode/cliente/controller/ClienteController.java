package com.letscode.cliente.controller;

import ch.qos.logback.core.net.server.Client;
import com.letscode.cliente.dto.ClienteDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private static Map<String, ClienteDTO> clientes = new HashMap<>();

    static {
      //  clientes.put("1", new ClienteDTO("1", "Eduardo", "1234"));
      //  clientes.put("2", new ClienteDTO("2", "Joao", "4321"));
      //  clientes.put("3", new ClienteDTO("3", "Jose", "3212"));
      //  clientes.put("4", new ClienteDTO("4", "Maria", "5432"));
    }

    @GetMapping
    public List<ClienteDTO> listClientes() {
        return new ArrayList<>(clientes.values());
    }

    @GetMapping("/{id}")
    public ClienteDTO getCliente(@PathVariable String id) {
        return clientes.get(id);
    }


}
