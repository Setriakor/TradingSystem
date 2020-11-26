package com.tradingsystem.ClientConnectivity;

import java.sql.Timestamp;
import java.util.*;

import com.tradingsystem.ClientConnectivity.Model.Client;

import com.tradingsystem.ClientConnectivity.Model.ClientService;
import com.tradingsystem.ClientConnectivity.gen.ClientOrder;
import com.tradingsystem.ClientConnectivity.gen.ValidateOrderResponse;

import com.tradingsystem.ClientConnectivity.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController  {
    @Autowired OrderClient client;
@Autowired
    ClientService clientService;
    @Autowired
    ClientRepository repo;

    @GetMapping("/")
    public String bulkcreate() {
        // save a single Customer
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        repo.save(new Client((long) 1, "Kwame Joshua", "John@gmail.com", "1233tty", "Accra", 3456, timestamp));
        repo.save(new Client((long) 2, "Eric Mensag", "eric@gmail.com", "1233tty", "Accra", 3456, timestamp));
        return "Clients created";
    }

        @RequestMapping(value = "/client/{Client_id}", method = RequestMethod.GET)
    public @ResponseBody List<Client> getAllClient(@PathVariable Long client_id) {
        return clientService.getById(client_id);
    }

    @RequestMapping(value = "/clientByName/{name}", method = RequestMethod.GET)
    public List<Client> getClientByName(@PathVariable String name) {
        return clientService.findByName(name);
    }


    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Client> getAll() {
        return clientService.getAllClients();
    }

//    RequestMapping(value = "/client/deleteclient/{client_id}", method = RequestMethod.DELETE)
//    public HttpStatus deleteClient(@PathVariable Long client_id) {
//        clientService.deleteClient(client_id);
//        return HttpStatus.NO_CONTENT;
//    }@


    @RequestMapping(value = "/client/insertclient", method = RequestMethod.POST)
    public HttpStatus insertclient(@RequestBody Client client) {
        return clientService.addClient(client) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping(value = "/client/updateclient", method = RequestMethod.PUT)
    public HttpStatus updateClient(@RequestBody Client client) {
        return clientService.updateClient(client) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }



    @PostMapping("/createOrder")
    public @ResponseBody ValidateOrderResponse createOrder(@RequestBody ClientOrder body) {
        ValidateOrderResponse resp= client.validateOrder(body);
        return resp;
    }
    
    
    
}
