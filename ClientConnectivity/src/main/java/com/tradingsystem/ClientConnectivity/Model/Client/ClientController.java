package com.tradingsystem.ClientConnectivity.Model.Client;

import java.util.*;

import com.tradingsystem.ClientConnectivity.OrderClient;
import com.tradingsystem.ClientConnectivity.gen.ClientOrder;
import com.tradingsystem.ClientConnectivity.gen.ValidateOrderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController  {
    @Autowired ClientRepository clientRepo;

    @PostMapping("/createClient")
	public @ResponseBody Client hello(@RequestBody Client body) {
        Client client= body;
        clientRepo.save(client);
		return body;
    }
}
