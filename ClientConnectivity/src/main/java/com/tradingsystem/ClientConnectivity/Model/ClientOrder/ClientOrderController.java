package com.tradingsystem.ClientConnectivity.Model.ClientOrder;

import com.tradingsystem.ClientConnectivity.OrderClient;
import com.tradingsystem.ClientConnectivity.gen.ValidateOrderResponse;

import com.tradingsystem.ClientConnectivity.gen.ClientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientOrderController {
    
    @Autowired OrderClient client;

    @PostMapping("/createClientOrder")
    public @ResponseBody ValidateOrderResponse createOrder(@RequestBody ClientOrder body) {
        ValidateOrderResponse resp= client.validateOrder(body);
        return resp;
    }



        @Autowired
        ClientOrderService clientOrderService;
        @Autowired
        ClientOrderRepository repo;

        @GetMapping("/bulkOreder")
        public String bulkOrdercreate() {
            // save a single Customer
          //  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            //repo.save(new ClientOrder( "Kwame Joshua", "John@gmail.com", "1233tty", "Accra", 3456));
          //  repo.save(new ClientOrder("");
            return "ClientOrder created";
        }

        @RequestMapping(value = "/clientOrder/{clientOrder}", method = RequestMethod.GET)
        public @ResponseBody
        Optional<com.tradingsystem.ClientConnectivity.Model.ClientOrder.ClientOrder> getAllClient(@PathVariable Long clientOrderId) {
            return clientOrderService.getById(clientOrderId);
        }



//    @RequestMapping(value = "/clientByName/{name}", method = RequestMethod.GET)
//    public List<Client> getClientByName(@PathVariable String name) {
//        return clientService.findByName(name);
//    }

        @PostMapping("/clientOrdertest")
        public @ResponseBody String test(){
            return "testing";
        }


        @RequestMapping(value = "/clientOrder", method = RequestMethod.GET)
        public List<com.tradingsystem.ClientConnectivity.Model.ClientOrder.ClientOrder> getAll() {
            return clientOrderService.getAllClientOrders();
        }

//    RequestMapping(value = "/client/deleteclient/{client_id}", method = RequestMethod.DELETE)
//    public HttpStatus deleteClient(@PathVariable Long client_id) {
//        clientService.deleteClient(client_id);
//        return HttpStatus.NO_CONTENT;
//    }@


        @RequestMapping(value = "/clientOrder/insertclientOrder", method = RequestMethod.POST)
        public HttpStatus insertclientOrder(@RequestBody com.tradingsystem.ClientConnectivity.Model.ClientOrder.ClientOrder clientOrder) {
            return clientOrderService.addClientOrder(clientOrder) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        }

        @RequestMapping(value = "/clientOrder/updateclientOrder", method = RequestMethod.PUT)
        public HttpStatus updateClientOrder(@RequestBody com.tradingsystem.ClientConnectivity.Model.ClientOrder.ClientOrder clientOrder) {
            return clientOrderService.updateClientOrder(clientOrder) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
        }

//    @GetMapping(value = "/client/{name}")
//    public List<Client> getSpecificCustomer(@PathVariable String name){
//        return (List<Client>) repo.findByName(name);
//    }

    }
