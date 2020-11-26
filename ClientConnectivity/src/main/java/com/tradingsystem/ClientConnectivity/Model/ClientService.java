package com.tradingsystem.ClientConnectivity.Model;
import java.util.List;


import com.tradingsystem.ClientConnectivity.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



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

//    @Transactional
//    public List<Client> getById(Long client_id) {
//        return clientRepository.findOne(client_id);
//    }

//    @Transactional
//    public void deleteClient(Long client_id) {
//        clientRepository.delete(client_id);
//    }

    @Transactional
    public boolean addClient(Client client) {
        return clientRepository.save(client) != null;
    }

    @Transactional
    public boolean updateClient(Client client) {
        return clientRepository.save(client) != null;
    }


    public List<Client> getById(Long client_id) {
        return (List<Client>) clientRepository.findAll();
    }
}