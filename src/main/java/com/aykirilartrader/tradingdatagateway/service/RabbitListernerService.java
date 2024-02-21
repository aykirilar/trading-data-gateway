package com.aykirilartrader.tradingdatagateway.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitListernerService {

    @RabbitListener(queues = "trademessages")
    public void receiveMessage(String message) {
        System.out.println("Received message from RabbitMQ: " + message);
    }
}
