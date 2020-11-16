package com.tradingsystem.OrderValidation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderValidationController {
    
    @PostMapping("/recieveOrder")
    public String recieveOrder(@RequestBody String order){
        return order;
    }
}
