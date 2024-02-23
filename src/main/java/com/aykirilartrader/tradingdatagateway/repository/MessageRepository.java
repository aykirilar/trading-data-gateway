package com.aykirilartrader.tradingdatagateway.repository;

import com.aykirilartrader.tradingdatagateway.model.RabbitMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<RabbitMessage, Long> {
}
