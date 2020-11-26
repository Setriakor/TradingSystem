package com.tradingsystem.ClientConnectivity.Model.ExchangeOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ExchangeOrderService {


    @Autowired
    ExchangeOrderRepository<ExchangeOrder> exchangeOrderRepository;

    @Transactional
    public List<ExchangeOrder> getAllexchangeOrder() {
        return (List<ExchangeOrder>) exchangeOrderRepository.findAll();
    }

//    @Transactional
//    public List<ExchangeOrder> findByName(String name) {
//        return ExchangeOrderRepository.findByName(name);
    //}

    @Transactional
    public boolean addExchangeOrder(ExchangeOrder exchangeOrder) {
        return exchangeOrderRepository.save(exchangeOrder) != null;
    }

    @Transactional
    public boolean updateExchangeOrder(ExchangeOrder exchangeOrder) {
        return exchangeOrderRepository.save(exchangeOrder) != null;
    }

    @Transactional
    public Optional<ExchangeOrder> getById(Long exchangeOrderId) {
        return exchangeOrderRepository.findById(exchangeOrderId);


    }
}
