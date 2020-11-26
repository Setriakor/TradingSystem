package com.tradingsystem.ClientConnectivity.Model;

import com.tradingsystem.ClientConnectivity.OrderClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class OrderConfig {
    
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller= new Jaxb2Marshaller();
        marshaller.setContextPath("com.tradingsystem.ClientConnectivity.gen");
        return marshaller;
    }

    @Bean
    public OrderClient client(Jaxb2Marshaller marshaller){
        OrderClient client= new OrderClient();
        client.setDefaultUri("http://localhost:9080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
