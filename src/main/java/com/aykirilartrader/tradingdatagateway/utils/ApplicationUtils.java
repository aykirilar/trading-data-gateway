package com.aykirilartrader.tradingdatagateway.utils;

import com.aykirilartrader.tradingdatagateway.indicators.Indicator;
import com.aykirilartrader.tradingdatagateway.indicators.MatrixIndicator;
import com.aykirilartrader.tradingdatagateway.indicators.UsdtDominanceIndicator;

import java.util.Map;

public class ApplicationUtils {
    public enum ORDER {
        BUY_ENTER(1),
        BUY_EXIT(2),
        SELL_ENTER(3),
        SELL_EXIT(4),
        NO_ACTION(5);

        public final int id;

        ORDER(int id) {
            this.id = id;
        }
    }

    public static final Map<String, Class<? extends Indicator>> indicators = Map.ofEntries(Map.entry("matrix", MatrixIndicator.class), Map.entry("usdt.d", UsdtDominanceIndicator.class));
}
