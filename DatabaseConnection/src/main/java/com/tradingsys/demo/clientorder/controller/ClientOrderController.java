//package com.tradingsys.demo.clientorder.controller;
//
//import com.turntabl.Client_Connectivity.clientorder.dao.ClientOrderDao;
//import com.turntabl.Client_Connectivity.clientorder.model.ClientOrder;
//import com.turntabl.Client_Connectivity.clientorder.model.SendOrderResponse;
//import com.turntabl.Client_Connectivity.exchangeorder.dao.ExchangeOrderDao;
//import com.turntabl.Client_Connectivity.exchangeorder.model.Data;
//import com.turntabl.Client_Connectivity.exchangeorder.model.ExchangeOrder;
//import com.turntabl.Client_Connectivity.exchangeorder.model.ResponseData;
//import com.turntabl.Client_Connectivity.portfolio.doa.PortfolioDao;
//import com.turntabl.Client_Connectivity.portfolio.model.Portfolio;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.List;
//
//@RestController
//public class ClientOrderController {
//
//    @Autowired
//    private final ClientOrderDao order;
//
//    @Autowired
//    private ExchangeOrderDao exchangeOrderDao;
//
//    @Autowired
//    private final PortfolioDao portfolioDao;
//
//    public ClientOrderController(ClientOrderDao order, PortfolioDao portfolioDao) {
//        this.order = order;
//        this.portfolioDao = portfolioDao;
//    }
//
//    @GetMapping("/api/orders")
//    List<ClientOrder> getAllOrders(){
//        return order.findAll();
//    }
//
//    @GetMapping("/api/orders/{id}")
//    ClientOrder getOrder(@PathVariable Integer id){
//        return order.findAllByClientOrderId(id);
//    }
//    @PostMapping("/api/orders")
//    ResponseData createOrder(@RequestBody ClientOrder orders){
//
//        ResponseData responseData = new ResponseData();
//        Data data = new Data();
//
//        ClientOrder clientOrder;
//        SendOrderResponse sendOrderResponse = new SendOrderResponse();
//
//        WebClient webClient = WebClient.create("http://localhost:8081");
//
//        String order_status = webClient.post()
//                .uri("/api/soap_consumer/sendOrder")
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .body(BodyInserters.fromValue(orders))
//                .retrieve()
//                .bodyToMono(SendOrderResponse.class)
//                .block().getMessage();
//
//        switch(order_status){
//            case("valid"):
//
//                ExchangeOrder exchangeOrder = new ExchangeOrder();
//
//                Portfolio portfolio = portfolioDao.findAllByPortfolioId(2);
//
//                orders.assignToPortfolio(portfolio);
//
//
//                clientOrder = order.save(orders);
//                exchangeOrder.setOrder(clientOrder);
//
//                exchangeOrderDao.save(exchangeOrder);
//
//                data.setOrderId(orders.getClientOrderId());
//                data.setUserId(portfolio.getUser().getUserId());
//                data.setPortfolioId(portfolio.getPortfolioId());
//
//                responseData.setData(data);
//                responseData.setMessage("Order sent");
//                responseData.setStatus_code(HttpStatus.CREATED.value());
//
//                break;
//            case("invalid"):
//                responseData.setMessage("Invalid Order");
//                responseData.setStatus_code(HttpStatus.FORBIDDEN.value());
//                break;
//        }
//
//        return responseData;
//    }
//
//    @PutMapping("/api/orders/{id}")
//    ClientOrder updateClientOrder (@PathVariable Integer id, @RequestBody ClientOrder newClientOrder){
//        ClientOrder clientOrder = order.findAllByClientOrderId(id);
//
//        clientOrder.setAlgorithm(newClientOrder.getAlgorithm());
//        clientOrder.setPortfolio(newClientOrder.getPortfolio());
//        clientOrder.setPrice(newClientOrder.getPrice());
//        clientOrder.setQuantity(newClientOrder.getQuantity());
//        clientOrder.setProduct(newClientOrder.getProduct());
//        clientOrder.setSide(newClientOrder.getSide());
//        clientOrder.setStatus(newClientOrder.getStatus());
//
//        return order.save(clientOrder);
//    }
//}