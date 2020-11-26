package com.tradingsystem.ClientConnectivity;

import com.tradingsystem.ClientConnectivity.gen.ClientOrder;
import com.tradingsystem.ClientConnectivity.gen.ValidateOrderRequest;
import com.tradingsystem.ClientConnectivity.gen.ValidateOrderResponse;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class OrderClient extends WebServiceGatewaySupport {

    public ValidateOrderResponse validateOrder(ClientOrder order){
        ValidateOrderRequest req= new ValidateOrderRequest();
        req.setOrder(order);

        ValidateOrderResponse resp= (ValidateOrderResponse) getWebServiceTemplate()
        .marshalSendAndReceive("http://localhost:8081/ws",req);
        return resp;
    }    
}
