package com.tradingsystem.OrderValidation;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;


@RestController
public class OrderValidationController {

    @PostMapping("/recieveOrder")
    public String recieveOrder(@RequestBody String order){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.publish("orderChannel", order);
        return "sent";
    }
}
