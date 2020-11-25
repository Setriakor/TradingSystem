package com.tradingsystem.ClientConnectivity.Model.ClientOrder;

import com.tradingsystem.ClientConnectivity.OrderClient;
import com.tradingsystem.ClientConnectivity.gen.ValidateOrderResponse;

import com.tradingsystem.ClientConnectivity.gen.ClientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientOrderController {
    
    @Autowired OrderClient client;

    @PostMapping("/createClientOrder")
    public @ResponseBody ValidateOrderResponse createOrder(@RequestBody ClientOrder body) {
        ValidateOrderResponse resp= client.validateOrder(body);
        return resp;
    }
}
