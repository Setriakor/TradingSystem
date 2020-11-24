package com.tradingsystem.TradingEngine;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisReceiver {
    static {
        Jedis jSubscriber = new Jedis();

        JedisPubSub handler = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                // handle message
                System.out.println(message);
                jSubscriber.lpush("orders", message);
            }
        };

        jSubscriber.subscribe(handler, "orderChannel");
    }
}
