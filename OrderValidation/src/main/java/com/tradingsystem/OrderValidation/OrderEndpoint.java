package com.tradingsystem.OrderValidation;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import localhost._8080.ValidateOrderRequest;
import localhost._8080.ValidateOrderResponse;

@Endpoint
public class OrderEndpoint {
    
    @PayloadRoot(namespace = "http://localhost:8080",localPart = "validateOrderRequest")
    @ResponsePayload
    public ValidateOrderResponse validateOrderRquest(@RequestPayload ValidateOrderRequest request) {
            ValidateOrderResponse resp= new ValidateOrderResponse();
            System.out.println(request.getOrder());
            resp.setValid(true);
            return resp;
    }
}
