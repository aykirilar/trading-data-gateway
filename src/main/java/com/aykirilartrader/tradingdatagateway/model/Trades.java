package com.aykirilartrader.tradingdatagateway.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "trades")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id")
    private Long tradeId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "entry_time")
    private Timestamp entryTime;

    @Column(name = "exit_time")
    private Timestamp exitTime;

    @Column(name = "enter_price")
    private BigDecimal enterPrice;

    @Column(name = "exit_price")
    private BigDecimal exitPrice;

    private BigDecimal margin;
    private Integer leverage;
    private String status;

    @Column(name = "trade_operation")
    private String tradeOperation;
}
