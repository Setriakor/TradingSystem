package com.tradingsystem.OrderValidation;

import java.util.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import localhost._8080.ClientOrder;
import reactor.core.publisher.Mono;

@RestController
public class Validator {
    boolean mainValid = false;
    String message = "";
    ClientOrder order;

    WebClient client = WebClient.builder().baseUrl("https://exchange.matraining.com")
            .defaultHeader("Content-Type", "application/json").build();
    WebClient internalClient = WebClient.builder().baseUrl("http://localhost:8080")
            .build();

    // public Validator(ClientOrder order) {
    //     this.order = order;
    // }

    
    public boolean productExists() {
        boolean valid = false;
        String ticker = order.getProduct();
        HashMap res = null;
        try {
            res = client.get().uri("/md/" + ticker).accept(MediaType.APPLICATION_JSON).retrieve()
                    .bodyToMono(HashMap.class).block();
            valid = true;
        } catch (Exception e) {
            message = "order does not exist";
        }
        return valid;

    }

    @PostMapping("/test")
    public @ResponseBody HashMap withinBalance() {
        boolean valid = false;
        message = "Total cost is creater than balance";
        HashMap user = null;
        try {
            // String client_id= order.getClientId();
            // System.out.println(client_id);
            user = internalClient.get().uri("/clients/1").retrieve().bodyToMono(HashMap.class)
                    .block();
            // double balance = (double) user.get("balance");
            // if (balance >= order.getPrice() * order.getQuantity()) {
            //     valid = true;
            // }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        return user;
    }

    // private boolean withinBalance() {
    // boolean valid = false;
    // message= "Total cost is creater than balance";
    // HashMap user=
    // internalClient.get().uri("/clients/"+order.getClientID()).retrieve().bodyToMono(HashMap.class).block();
    // double balance= (double) user.get("balance");
    // if(balance>= order.getPrice()*order.getQuantity()){
    // valid=true;
    // }
    // return valid;
    // }

    private boolean withinLimit() {
        boolean valid = false;
        message = "Order quantity is outside the buy or sell limit";
        HashMap res = client.get().uri("/md/" + order.getProduct()).accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToMono(HashMap.class).block();
        int limit = (int) res.get(order.getSide() + "_LIMIT");
        if (order.getQuantity() <= limit) {
            valid = true;
        }
        return valid;
    }

    private boolean withinShift() {
        boolean valid = false;
        message = "Order price is above or below the allowed price limit";
        HashMap res = client.get().uri("/md/" + order.getProduct()).accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToMono(HashMap.class).block();
        int maxShift = (int) res.get("MAX_PRICE_SHIFT");
        double lastPrice = (double) res.get("LAST_TRADED_PRICE");
        if (order.getPrice() >= maxShift - lastPrice && order.getPrice() <= maxShift + lastPrice) {
            valid = true;
        }
        return valid;
    }

    public boolean checkOrderValidity() {
        //boolean buyBool = withinBalance();
        if (order.getSide().equals("BUY")) {
            if (productExists() && withinLimit() && withinShift()) {
                mainValid = true;
                message = "order is valid";
            }
        } else {
            if (productExists() && withinLimit() && withinShift()) {
                mainValid = true;
                message = "order is valid";
            }
        }
        return mainValid;
    }

    public String getMessage() {
        return message;
    }

}
