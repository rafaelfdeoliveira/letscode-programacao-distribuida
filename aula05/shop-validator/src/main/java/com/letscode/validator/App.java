package com.letscode.validator;

import com.letscode.shop.dto.ClienteDTO;
import com.letscode.shop.dto.ProdutoDTO;
import com.letscode.validator.redis.CacheClienteService;
import com.letscode.validator.redis.ProdutoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CacheClienteService clienteService, ProdutoService produtoService) {
        return args -> {

            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setIdentifier("123456");
            clienteDTO.setNome("Eduardo");
            clienteDTO.setEndereco("Rua abc");

            clienteService.salvarComTimeout(clienteDTO);
            System.out.println(clienteService.get(clienteDTO.getIdentifier()));


            ProdutoDTO produtoDTO = ProdutoDTO.builder().identificador("1234").preco(1000F).build();
            ProdutoDTO produtoDTO1 = ProdutoDTO.builder().identificador("12345").preco(1000F).build();
            ProdutoDTO produtoDTO2 = ProdutoDTO.builder().identificador("123456").preco(1000F).build();

            produtoService.push(produtoDTO);
            produtoService.push(produtoDTO1);
            produtoService.push(produtoDTO2);

            System.out.println(produtoService.getProdutos(0, 5));

        };
    }
}
