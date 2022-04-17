package com.letscode.cliente.controller;

import com.letscode.cliente.dto.ClientDTO;
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
public class ClientController {

    private static Map<String, ClientDTO> clients = new HashMap<>();

    static {
        clients.put("1", new ClientDTO("1", "12345", "c1"));
        clients.put("2", new ClientDTO("2", "43210", "c1"));
        clients.put("3", new ClientDTO("3", "43222", "c1"));
        clients.put("4", new ClientDTO("4", "31223", "c1"));
    }

    @GetMapping
    public List<ClientDTO> listClients() {
        return new ArrayList<>(clients.values());
    }

    @GetMapping("/{identifier}")
    public ClientDTO getClient(@PathVariable String identifier) {
        return clients.get(identifier);
    }

}
