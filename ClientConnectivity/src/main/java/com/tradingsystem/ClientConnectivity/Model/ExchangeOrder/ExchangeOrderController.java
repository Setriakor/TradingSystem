package com.tradingsystem.ClientConnectivity.Model.ExchangeOrder;

import com.tradingsystem.ClientConnectivity.Model.Client.Client;
import com.tradingsystem.ClientConnectivity.Model.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExchangeOrderController {

        @Autowired
        ExchangeOrderService exchangeOrderService;
        @Autowired
        ExchangeOrderRepository<ExchangeOrder> repo;
//
//        @GetMapping("/bulk")
//        public String bulkcreateexchangeorder() {
//            // save a single Customer
//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//            //repo.save(new Client( "Kwame Joshua", "John@gmail.com", "1233tty", "Accra", 3456));
//            repo.save(new Client("Eric Mensag", "eric@gmail.com", "1233tty", "Accra", 3456));
//            return "Clients created";
//        }

        @RequestMapping(value = "/exchangeOrder/{exchangeOrder_id}", method = RequestMethod.GET)
        public @ResponseBody
        Optional<ExchangeOrder> getAllExchangeOrder(@PathVariable Long exchangeOrderId) {
            return exchangeOrderService.getById(exchangeOrderId);
        }



//    @RequestMapping(value = "/clientByName/{name}", method = RequestMethod.GET)
//    public List<Client> getClientByName(@PathVariable String name) {
//        return clientService.findByName(name);
//    }

        @PostMapping("/exchangeOrdertest")
        public @ResponseBody String test(){
            return "testing";
        }


        @RequestMapping(value = "/ExchangeOrder", method = RequestMethod.GET)
        public List<ExchangeOrder> getAll() {
            return exchangeOrderService.getAllexchangeOrder();
        }

//    RequestMapping(value = "/client/deleteclient/{client_id}", method = RequestMethod.DELETE)
//    public HttpStatus deleteClient(@PathVariable Long client_id) {
//        clientService.deleteClient(client_id);
//        return HttpStatus.NO_CONTENT;
//    }@


        @RequestMapping(value = "/ExchangeOrder/insertclient", method = RequestMethod.POST)
        public HttpStatus insertExchangeOrder(@RequestBody ExchangeOrder exchangeOrder) {
            return exchangeOrderService.addExchangeOrder(exchangeOrder) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        }

        @RequestMapping(value = "/exchangeOrder/updateExchangeOrder", method = RequestMethod.PUT)
        public HttpStatus updateClient(@RequestBody ExchangeOrder exchangeOrder) {
            return exchangeOrderService.updateExchangeOrder(exchangeOrder) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
        }

    }
