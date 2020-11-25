package com.tradingsystem.ClientConnectivity;

import java.util.*;

import com.tradingsystem.ClientConnectivity.Model.Client;
import com.tradingsystem.ClientConnectivity.gen.ClientOrder;
import com.tradingsystem.ClientConnectivity.gen.ValidateOrderRequest;
import com.tradingsystem.ClientConnectivity.gen.ValidateOrderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@RestController
public class ClientController  {
    @Autowired OrderClient client;

    @PostMapping("/createClient")
	public @ResponseBody Client hello(@RequestBody Client body) {
        Client client= body;
        System.out.println(client);
		return body;
    }

    @PostMapping("/createOrder")
    public @ResponseBody ValidateOrderResponse createOrder(@RequestBody ClientOrder body) {
        ValidateOrderResponse resp= client.validateOrder(body);
        return resp;
    }
    
    
    
}
