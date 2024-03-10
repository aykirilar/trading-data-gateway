package com.aykirilartrader.tradingdatagateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Duration;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer leverage;
    @Column(name = "trade_on_off")
    private Boolean tradeOnOff;
    @Column(name = "candle_size")
    private int candleSize;
    private String method;
}
