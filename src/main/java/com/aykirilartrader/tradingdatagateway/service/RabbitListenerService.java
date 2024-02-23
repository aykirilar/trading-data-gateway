package com.aykirilartrader.tradingdatagateway.service;

import com.aykirilartrader.tradingdatagateway.model.RabbitMessage;
import com.aykirilartrader.tradingdatagateway.repository.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RabbitListenerService {

    private final MessageRepository messageRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public RabbitListenerService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        this.objectMapper = new ObjectMapper();
    }

    @RabbitListener(queues = "trademessages")
    public void receiveMessage(String messageData) {
        try {
            RabbitMessage message = objectMapper.readValue(messageData, RabbitMessage.class);
            messageRepository.save(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
