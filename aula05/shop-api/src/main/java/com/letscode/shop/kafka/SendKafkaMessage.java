package com.letscode.shop.kafka;

import com.letscode.shop.dto.CompraDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendKafkaMessage {

    private final KafkaTemplate<String, CompraDTO> kafkaTemplate;

    public static final String KAFKA_TOPIC = "NOVO_COMPRO_TOPICO_2";

    public void sendMessage(CompraDTO compra) {
        kafkaTemplate.send(KAFKA_TOPIC, compra);
    }

}
