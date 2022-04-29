package com.letscode.validator.kafka;

import com.letscode.shop.dto.CompraDTO;
import org.apache.kafka.common.network.Send;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

@ExtendWith(MockitoExtension.class)
public class SendKafkaMessageTests {

    @InjectMocks
    private SendKafkaMessage sendKafkaMessage;

    @Mock
    private KafkaTemplate<String, CompraDTO> kafkaTemplate;

    @Test
    public void testSendMessage() {
        CompraDTO compraDTO = new CompraDTO();
        sendKafkaMessage.sendMessage(compraDTO);

        Mockito.verify(kafkaTemplate, Mockito.times(1))
                .send(SendKafkaMessage.KAFKA_TOPIC, compraDTO);
    }


}
