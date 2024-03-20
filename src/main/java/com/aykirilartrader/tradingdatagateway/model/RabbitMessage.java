package com.aykirilartrader.tradingdatagateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @PrePersist
    protected void onCreate() {
        receivedAt = new Timestamp(System.currentTimeMillis());
    }
}
