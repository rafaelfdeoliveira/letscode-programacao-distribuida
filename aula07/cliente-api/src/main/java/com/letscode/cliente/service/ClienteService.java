package com.letscode.cliente.service;

import com.letscode.cliente.dto.ClienteDTO;
import com.letscode.cliente.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final MongoTemplate mongoTemplate;

    public Page<Cliente> listClientes(Cliente cliente, Pageable pageable) {
        List<Criteria> criteriaList = new ArrayList<>();
        if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
            criteriaList.add(Criteria.where("nome").is(cliente.getNome()));
        }
        if (cliente.getCpf() != null && !cliente.getCpf().isEmpty()) {
            criteriaList.add(Criteria.where("cpf").is(cliente.getCpf()));
        }

        Criteria criteria = new Criteria().andOperator(criteriaList);
        Query query = Query.query(criteria).with(pageable);
        Query queryCount = Query.query(criteria);

        Long count = mongoTemplate.count(queryCount, Cliente.class);
        List<Cliente> listClientes = mongoTemplate.find(query, Cliente.class);

        return new PageImpl<>(
                listClientes,
                pageable,
                count
        );
    }


}
