package com.tradingsystem.ExchangeConnectivity;

import com.google.gson.Gson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class ExchangeConnectivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeConnectivityApplication.class, args);
		Jedis jedis = new Jedis();
		while (true) {
			String cOrder = jedis.lpop("orders");
			if (cOrder != null) {
				System.out.println(cOrder);
				Gson gson = new Gson();
				ExchangeOrder eOrder = gson.fromJson(cOrder, ExchangeOrder.class);
				System.out.println(eOrder);
				WebClient client = WebClient.builder()
						.baseUrl("https://exchange.matraining.com/afc5ab59-f39a-4394-a905-9817ee2e1aed")
						.defaultHeader("Content-Type", "application/json").build();
				Mono<String> id = client.post()
				.uri("/order").body(Mono.just(eOrder), ExchangeOrder.class)
				.retrieve().bodyToMono(String.class);
				System.out.println(id.block());
				eOrder.setId(id.block());
				System.out.println(eOrder);
			}
		}
	}

}
