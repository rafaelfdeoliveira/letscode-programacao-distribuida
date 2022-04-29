package com.letscode.validator.redis;


import com.letscode.shop.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CacheClienteService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void salvar(ClienteDTO clienteDTO) {
        redisTemplate.opsForValue().set(clienteDTO.getIdentifier(), clienteDTO);
    }

    public void salvarComTimeout(ClienteDTO clienteDTO) {
        redisTemplate.opsForValue().set(clienteDTO.getIdentifier(), clienteDTO, 30, TimeUnit.SECONDS);
    }

    public ClienteDTO get(String identifier) {
        return (ClienteDTO) redisTemplate.opsForValue().get(identifier);
    }


}
