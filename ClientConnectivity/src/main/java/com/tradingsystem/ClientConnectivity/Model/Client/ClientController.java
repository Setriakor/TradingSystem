package com.tradingsystem.ClientConnectivity.Model.Client;

//import java.security.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {


    @Autowired
    ClientService clientService;
    @Autowired
    ClientRepository repo;

    @GetMapping("/bulk")
    public String bulkcreate() {
        // save a single Customer
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //repo.save(new Client( "Kwame Joshua", "John@gmail.com", "1233tty", "Accra", 3456));
        repo.save(new Client("Eric Mensag", "eric@gmail.com", "1233tty", "Accra", 3456));
        return "Clients created";
    }

    @RequestMapping(value = "/client/{client_id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Client> getAllClient(@PathVariable Long client_id) {
        return clientService.getById(client_id);
    }



//    @RequestMapping(value = "/clientByName/{name}", method = RequestMethod.GET)
//    public List<Client> getClientByName(@PathVariable String name) {
//        return clientService.findByName(name);
//    }

    @PostMapping("/test")
    public @ResponseBody String test(){
        return "testing";
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

//    @GetMapping(value = "/client/{name}")
//    public List<Client> getSpecificCustomer(@PathVariable String name){
//        return (List<Client>) repo.findByName(name);
//    }

}

