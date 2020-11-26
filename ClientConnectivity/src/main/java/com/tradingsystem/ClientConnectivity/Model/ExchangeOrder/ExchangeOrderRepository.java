package com.tradingsystem.ClientConnectivity.Model.ExchangeOrder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeOrderRepository<E> extends JpaRepository<ExchangeOrder,Long> {

    //List<ExchangeOrder> findByName(String name);
    List<ExchangeOrder> findAll();
    
}
