package com.letscode.validator.redis;


import com.letscode.shop.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void push(ProdutoDTO produtoDTO) {
        redisTemplate.opsForList().rightPush("produtos", produtoDTO);
    }

    public ProdutoDTO pop() {
        return (ProdutoDTO) redisTemplate.opsForList().leftPop("produtos");
    }

    public List<Object> getProdutos(long inicio, long fim) {
        return redisTemplate.opsForList().range("produtos", inicio, fim);
    }

}
