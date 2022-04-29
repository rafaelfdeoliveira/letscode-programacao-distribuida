package com.letscode.shop.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
public class ClienteDTO implements Serializable {
    private String identifier;
    private String nome;
    private String endereco;
}
