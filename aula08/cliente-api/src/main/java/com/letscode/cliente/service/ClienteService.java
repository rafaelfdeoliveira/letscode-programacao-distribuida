package com.letscode.cliente.service;

import com.letscode.cliente.dto.ClienteDTO;
import com.letscode.cliente.model.Cliente;
import com.letscode.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final MongoTemplate mongoTemplate;
    private final ClienteRepository clienteRepository;

    public Page<ClienteDTO> listClientes(ClienteDTO cliente, Pageable pageable) {
        List<Criteria> criteriaList = new ArrayList<>();
        if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
            criteriaList.add(Criteria.where("nome").is(cliente.getNome()));
        }
        if (cliente.getCpf() != null && !cliente.getCpf().isEmpty()) {
            criteriaList.add(Criteria.where("cpf").is(cliente.getCpf()));
        }
        if (cliente.getEndereco() != null && cliente.getEndereco().getCidade() != null) {
            criteriaList.add(Criteria.where("endereco.cidade").is(cliente.getEndereco().getCidade()));
        }

        Criteria criteria = new Criteria().andOperator(criteriaList);
        Query query = Query.query(criteria).with(pageable);
        Query queryCount = Query.query(criteria);

        Long count = mongoTemplate.count(queryCount, Cliente.class);
        List<ClienteDTO> listClientes = mongoTemplate
                .find(query, Cliente.class)
                .stream()
                .map(ClienteDTO::convert)
                .collect(Collectors.toList());

        return new PageImpl<>(
                listClientes,
                pageable,
                count
        );
    }

    public Page<ClienteDTO> findAll(Pageable pageable) {
        return clienteRepository
                .findAll(pageable)
                .map(ClienteDTO::convert);
    }

    public ClienteDTO findById(String id) {
        return ClienteDTO.convert(clienteRepository.findById(id).get());
    }

    public Cliente save(ClienteDTO dto) {
        Cliente cliente = Cliente.convert(dto);
        cliente.setId(UUID.randomUUID().toString());
        return clienteRepository.save(cliente);
    }

    @Async
    @SneakyThrows
    public Future<Integer> conta(Integer numero) {
        Integer soma = IntStream
                .range(1, numero)
                .sum();

        Thread.sleep(5000);

        return new AsyncResult<>(soma);
    }

}
