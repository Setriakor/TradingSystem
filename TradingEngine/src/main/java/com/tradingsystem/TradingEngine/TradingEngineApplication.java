package com.tradingsystem.TradingEngine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

@SpringBootApplication
public class TradingEngineApplication {
	public static void main(String[] args) {
		SpringApplication.run(TradingEngineApplication.class, args);
		//RedisReceiver receiver= new RedisReceiver();
		Jedis jSubscriber = new Jedis();
		Jedis queueJedis= new Jedis();

        JedisPubSub handler = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                // handle message
				System.out.println(message);
                queueJedis.lpush("orders", message);
            }
        };

        jSubscriber.subscribe(handler, "orderChannel");
	}

}
