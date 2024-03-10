package com.aykirilartrader.tradingdatagateway.restapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCheckResponse {
    private String order;
    private String message;
}
