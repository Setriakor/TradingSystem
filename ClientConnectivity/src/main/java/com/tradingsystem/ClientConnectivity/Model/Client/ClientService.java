package com.tradingsystem.ClientConnectivity.Model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {


    @Autowired
    ClientRepository<Client> clientRepository;

    @Transactional
    public List<Client> getAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Transactional
    public List<Client> findByName(String name) {
        return clientRepository.findByName(name);
    }
    @Transactional
    public boolean addClient(Client client) {
        return clientRepository.save(client) != null;
    }

    @Transactional
    public boolean updateClient(Client client) {
        return clientRepository.save(client) != null;
    }

   @Transactional
    public Optional<Client> getById(Long client_id) {
        return clientRepository.findById(client_id);


    }

//    @Transactional
//    public List<Client> findById(Long client_id) {
//        return clientRepository.findById(client_id);
//    }
}
