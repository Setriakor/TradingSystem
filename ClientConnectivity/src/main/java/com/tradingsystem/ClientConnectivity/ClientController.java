package com.tradingsystem.ClientConnectivity;

import java.util.*;

import com.tradingsystem.ClientConnectivity.Model.Client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @PostMapping("/addClient")
	public @ResponseBody Client hello(@RequestBody Client body) {
        Client client= body;
        System.out.println(client);
		return body;
    }

    @PostMapping("/createOrder")
    public @ResponseBody String createOrder(@RequestBody ClientOrder body){

    }
    
    
    
}
