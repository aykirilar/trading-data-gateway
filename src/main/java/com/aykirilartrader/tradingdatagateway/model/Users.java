package com.aykirilartrader.tradingdatagateway.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Duration;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer leverage;
    @Column(name = "trade_on_off")
    private Boolean tradeOnOff;

    @Column(name = "available_trade_timespan")
    private Duration availableTradeTimespan;

    @Column(name = "candle_size")
    private Duration candleSize;

    private String method;
}
