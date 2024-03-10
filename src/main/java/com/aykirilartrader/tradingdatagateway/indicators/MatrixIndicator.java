package com.aykirilartrader.tradingdatagateway.indicators;

import com.aykirilartrader.tradingdatagateway.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatrixIndicator extends Indicator {
    @Autowired
    DbService dbService;

    private static final int WEIGHT = 100;

    @Override
    public double calculateCoefficient() {
        return 2.0;
    }
}
