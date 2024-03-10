package com.aykirilartrader.tradingdatagateway.repository;

import com.aykirilartrader.tradingdatagateway.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
}
