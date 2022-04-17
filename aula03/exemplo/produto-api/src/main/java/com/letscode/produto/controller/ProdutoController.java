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
@RequestMapping("/product")
public class ProdutoController {

    private static Map<String, ProdutoDTO> products = new HashMap<>();

    static {
        products.put("1", new ProdutoDTO("1", "TV", 3000F));
        products.put("2", new ProdutoDTO("2", "PS4", 5000F));
        products.put("3", new ProdutoDTO("3", "Notebook", 5000F));
        products.put("4", new ProdutoDTO("4", "Geladeira", 2000F));
    }

    @GetMapping
    public List<ProdutoDTO> getProdutos() {
        return new ArrayList<>(products.values());
    }

    @GetMapping("/{identifier}")
    public ProdutoDTO getProduto(@PathVariable String identifier) {
        return products.get(identifier);
    }

}
