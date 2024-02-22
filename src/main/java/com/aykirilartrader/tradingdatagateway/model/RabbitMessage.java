package com.aykirilartrader.tradingdatagateway.model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
public class RabbitMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pair;
    private String timespan;

    @Column(name = "ordertype")
    private String orderType;
    @Column(name = "updated_at")
    private Timestamp receivedAt;

    public RabbitMessage() {
        this.receivedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public String getPair() {
        return pair;
    }

    public String getTimespan() {
        return timespan;
    }

    public String getOrderType() {
        return orderType;
    }
    public Timestamp getReceivedAt() {
        return receivedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public void setTimespan(String timespan) {
        this.timespan = timespan;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    public void setReceivedAt(Timestamp receivedAt) {
        this.receivedAt = receivedAt;
    }
}

