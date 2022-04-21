package com.letscode.shop.kafka;

import com.letscode.shop.controller.CompraController;
import com.letscode.shop.dto.CompraDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {

    private final String KAFKA_TOPIC = "COMPRA_TOPICO_PROCESSADA";

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "group-1")
    public void listenTopic3(CompraDTO compraDTO) {
        CompraController.compras.put(compraDTO.getIdentificador(), compraDTO);
    }

}
