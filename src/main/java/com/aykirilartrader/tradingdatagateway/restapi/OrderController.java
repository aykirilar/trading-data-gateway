package com.aykirilartrader.tradingdatagateway.restapi;

import com.aykirilartrader.tradingdatagateway.exceptions.InvalidRequestException;
import com.aykirilartrader.tradingdatagateway.service.DbService;
import com.aykirilartrader.tradingdatagateway.service.DecisionMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class OrderController {
    @Autowired
    private DecisionMakerService decisionMakerService;

    @GetMapping(path = "/check_order")
    public ResponseEntity<Objects> checkOrder(@RequestParam(value = "type") String type,
                                              @RequestParam(value = "user") String user,
                                              @RequestParam(value = "pair") String pair,
                                              @RequestParam(value = "timespan") String timespan) throws InvalidRequestException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        switch (type) {
            case "enter_buy":
                decisionMakerService.control(12345, "BTC/USDT", "240");
                break;
            case "enter_sell":
                break;
            case "exit_buy":
                break;
            case "exit_sell":
                break;
            default:
                throw new InvalidRequestException("invalid type");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String generateOrder(String user, String pair, String timespan) {
        // kullnıcı user tablosundan doğrulanır. aktif ise pair lerin tutulduğu tablodan user ın kullanacağı
        // göstergeler için buy/sell sinyal durumunu sorgulayacak. Eğer pozisyon yoksa; buy veya sell sinyalini oluşturabilecek.
        // Eğer kullanıcının aktif pozisyonu varsa; sadece aksi sinyal oluşuyorsa order bilgisi dönülecek.
        return "BUY";
        // return "SELL";
    }
}
