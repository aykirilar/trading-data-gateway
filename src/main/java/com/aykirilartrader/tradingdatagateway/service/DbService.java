package com.aykirilartrader.tradingdatagateway.service;

import com.aykirilartrader.tradingdatagateway.model.Users;
import com.aykirilartrader.tradingdatagateway.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    private final UserRepository userRepository;

    public DbService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveTrade(String user, String pair, String timespan, String order) {

    }

    public Users getUserInfo(int userid) {
        return Users.builder().id(12345).candleSize(3).leverage(10).tradeOnOff(true).method("matrix;usdt.d").build();
        //return userRepository.getReferenceById(userid);
    }
}
