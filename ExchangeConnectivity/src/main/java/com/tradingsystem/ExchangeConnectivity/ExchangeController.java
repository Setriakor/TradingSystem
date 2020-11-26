package com.tradingsystem.ExchangeConnectivity;

<<<<<<< HEAD
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ExchangeController {
    //ExchangeOrder ClientOrder = new ExchangeOrder("IBM", "50", "0.12", "BUY");

    @PostMapping("/placeOrder")
    public String placeOder(@RequestBody ExchangeOrder ClientOrder) {
        String orderID;

        WebClient client = WebClient.builder()
                .baseUrl("https://exchange.matraining.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        orderID = client.post()
                .uri("afc5ab59-f39a-4394-a905-9817ee2e1aed/order")
                .body(Mono.just(ClientOrder), ExchangeOrder.class)
                .retrieve().bodyToMono(String.class).block();
        return orderID;
    }

//    @PutMapping("/updateOrder")
//    public String updateOder(@RequestBody ExchangeOrder ClientOrder) {
//        String orderID;
//
//        WebClient client = WebClient.builder()
//                .baseUrl("https://exchange.matraining.com")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//        orderID = client.post()
//                .uri("afc5ab59-f39a-4394-a905-9817ee2e1aed/order")
//                .body(Mono.just(ClientOrder), ExchangeOrder.class)
//                .retrieve().bodyToMono(String.class).block();
//        return orderID;
//    }

    @DeleteMapping("/cancelOrder/{orderID}")
    public Boolean cancelOrder(@PathVariable String orderID) {
        Boolean state;

        WebClient client = WebClient.builder()
                .baseUrl("https://exchange.matraining.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        state = client.delete()
                .uri("/afc5ab59-f39a-4394-a905-9817ee2e1aed/order/" + orderID)
                .retrieve().bodyToMono(Boolean.class)
                .block();

        return state;


    }
}


=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ExchangeController {
    

    public void postOrder(){
        
    }
}
>>>>>>> 459adb4bc26e3858eb17bde0802af05677be4e39
