package com.aykirilartrader.tradingdatagateway.repository;

import com.aykirilartrader.tradingdatagateway.model.Trades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trades, Long> {
}
