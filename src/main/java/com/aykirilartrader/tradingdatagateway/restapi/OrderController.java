package com.aykirilartrader.tradingdatagateway.restapi;

import com.aykirilartrader.tradingdatagateway.exceptions.InvalidRequestException;
import com.aykirilartrader.tradingdatagateway.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/")
public class OrderController {
    private final DbService dbService;

    public OrderController(DbService dbService) {
        this.dbService = dbService;
    }

    @GetMapping(path = "/check_order")
    public ResponseEntity<Objects> checkOrder(@RequestParam(value = "type") String type,
                                              @RequestParam(value = "user") String user,
                                              @RequestParam(value = "pair") String pair,
                                              @RequestParam(value = "timespan") String timespan) throws InvalidRequestException {
        switch (type) {
            case "check_order":
                break;
            case "enter_buy":
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
