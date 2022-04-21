package com.letscode.validator.kafka;

import com.letscode.shop.dto.ClienteDTO;
import com.letscode.shop.dto.CompraDTO;
import com.letscode.shop.dto.ProdutoDTO;
import com.letscode.validator.service.ClienteService;
import com.letscode.validator.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.network.Send;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {


    public static final String KAFKA_TOPIC = "COMPRA_TOPICO";
    private final SendKafkaMessage sendKafkaMessage;

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "grupo-1")
    public void listenTopic(CompraDTO compraDTO) {

        ClienteDTO clienteDTO = ClienteService.getClient(compraDTO.getIdentificadorCliente());
        if (clienteDTO == null && clienteDTO.getIdentifier() != null) {
            throw new RuntimeException("Client not found.");
        }

        Float valorTotal = 0F;
        for (String produto : compraDTO.getIdentificadoresProdutos()) {
            ProdutoDTO produtoDTO = ProdutoService.getProduto(produto);
            if (produtoDTO == null) {
                throw new RuntimeException("Produto invalido.");
            }
            valorTotal += produtoDTO.getPreco();
        }
        compraDTO.setValorTotal(valorTotal);
        compraDTO.setStatus("PROCESSADA");

        System.out.println("Compra processada: " + compraDTO.getIdentificador() + " " + compraDTO.getValorTotal());
        sendKafkaMessage.sendMessage(compraDTO);

    }

}
