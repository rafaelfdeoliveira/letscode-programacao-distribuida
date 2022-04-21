package com.letscode.produto.controller;

import com.letscode.produto.dto.ProdutoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private static Map<String, ProdutoDTO> produtos = new HashMap<>();

    static {
        produtos.put("1", new ProdutoDTO("1", "TV", 3000F));
        produtos.put("2", new ProdutoDTO("2", "PS5", 5000F));
        produtos.put("3", new ProdutoDTO("3", "Notebook", 4000F));
        produtos.put("4", new ProdutoDTO("4", "Geladeira", 2000F));
    }

    @GetMapping
    public List<ProdutoDTO> listProdutos() {
        return new ArrayList<>(produtos.values());
    }

    @GetMapping("/{id}")
    public ProdutoDTO getProduto(@PathVariable String id) {
        return produtos.get(id);
    }

}
