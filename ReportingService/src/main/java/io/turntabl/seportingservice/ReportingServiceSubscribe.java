package io.turntabl.seportingservice;



import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportingServiceSubscribe {
    private final List<String> messageList = new ArrayList<>();
    public   Jedis subscriber = new Jedis("127.0.0.1",6379);


    @Bean
    public void subscriber() {
        //Jedis jedis = new Jedis("192.168.108.130" , 6379);
        this.subscriber.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
//                super.onMessage(channel, message);
                System.out.println(channel + " : " + message);
                messageList.add(channel + "_" + message);
            }
        }, "TradeEngineService", "ClientConnectivityService", "ExchangeConnectivityService"); //This refers to the services you would like to listen to
    }
}