package com.letscode.cliente.repository;

import com.letscode.cliente.dto.ClienteDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteDTO, String> {
}
