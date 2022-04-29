package com.letscode.cliente.service;

import com.letscode.cliente.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
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

    public void salvar() {

        ClienteDTO cliente = ClienteDTO
                .builder()
                .id(UUID.randomUUID().toString())
                .nome("Maria")
                .cpf("12345")
                .idade(30)
                .dataNascimento(LocalDate.now())
                .telefones(Arrays.asList("123","4332", "31231"))
                .build();


        mongoTemplate.save(cliente);
    }

    public void busca() {

        List<Criteria> criterias = new ArrayList<>();
        // criterias.add(Criteria.where("nome").is("Eduardo"));
        // criterias.add(Criteria.where("idade").lte(20));
        //criterias.add(Criteria.where("telefones").size(3));

        Criteria criteria = new Criteria();

        Query query = new Query().with(Sort.by("idade"));

        List<ClienteDTO> clientes =
                mongoTemplate.find(query, ClienteDTO.class);

        clientes.forEach(x -> System.out.println(x.getNome() + " " + x.getIdade()));
    }




}
