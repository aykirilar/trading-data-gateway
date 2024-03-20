package com.aykirilartrader.tradingdatagateway.service;

import com.aykirilartrader.tradingdatagateway.indicators.Indicator;
import com.aykirilartrader.tradingdatagateway.model.Users;
import com.aykirilartrader.tradingdatagateway.utils.ApplicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DecisionMakerService {
    private DbService dbService;

    @Autowired
    public void setMissionService(DbService dbService) {
        this.dbService = dbService;
    }

    public ApplicationUtils.ORDER control(int userid, String pair, String timespan) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /** burada fraqtrade den status control isteği geldi. Bu istek freqtrade tarafında herhangi bir zamanda gelebilir.
         * Öncelikli burada userid, pair ve timespan için aktif trade var mı yok mu kontrol edilecek.
         * Bu method userid, pair ve time span için BUY_ENTER, BUY_EXIT, SELL_ENTER, SELL_EXIT ve NO_TRADE_ZONE durumları döner.
         * BUY_ENTER ve SELL_ENTER durumları aktif trade yoksa, BUY_EXIT ve SELL_EXIT durumları aktif trade varsa,  NO_TRADE_ZONE durumu herhangi bir zamanda dönülebilir.
         * Kullanıcı için tanımlı indicatorler için tek tek ağırlık hesabı yapılacak. Bu değere coefficient diyelim. Bu değer kullanılarak varsa trade durumuna yoksa girilecek trade yönüne karar verilecek.
         * coefficient = 1 ise BUY_ENTER veya SELL_EXIT, coefficient < -1 ise SELL_ENTER veya BUY_EXIT, 1 > coefficient > -1 ise NO_TRADE_ZONE durumu türetilecektir.
         * user tablosundan kullanıcının trade durumu alınacak. Bu durum kullanıcının yeni bir trade işlemi yapmayacağını gösterir. Trade durumu pasife çekilmiş ise türetilebilecek durumlar : BUY_EXIT, SELL_EXIT ve NO_TRADE_ZONE
         * kullanıcının kullanmak istediği incatorler method alanında ";" ayıracı ile beklirleneceği kabul edilecek. Her incicator için hesaplanan katsayılar matematiksek olarak
        */



        Users user = dbService.getUserInfo(userid);
        double positive, negative, notr;
        List<Indicator> indicators = new ArrayList<>();

        for (String item : user.getMethod().split(";")) {
            System.out.println("Indicator : " + item + ", Coefficient : " + ApplicationUtils.indicators.get(item).getConstructor().newInstance().calculateCoefficient());
            ApplicationUtils.indicators.get(item).getConstructor().newInstance().calculateCoefficient();
        }
        return ApplicationUtils.ORDER.SELL_ENTER;
    }
}
