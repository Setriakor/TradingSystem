package com.tradingsystem.ClientConnectivity.Model.ClientOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ClientOrderService {



        @Autowired
        ClientOrderRepository<ClientOrder> clientOrderRepository;

        @Transactional
        public List<ClientOrder> getAllClientOrders() {
            return (List<ClientOrder>) clientOrderRepository.findAll();
        }
//
//        @Transactional
//        public List<ClientOrder> findByName(String name) {
//            return clientOrderRepository.findByName(name);
//        }
        @Transactional
        public boolean addClientOrder(ClientOrder clientOrder) {
            return clientOrderRepository.save(clientOrder) != null;
        }

        @Transactional
        public boolean updateClientOrder(ClientOrder clientOrder) {
            return clientOrderRepository.save(clientOrder) != null;
        }

        @Transactional
        public Optional<ClientOrder> getById(Long clientOrderId) {
            return clientOrderRepository.findById(clientOrderId);


        }

//    @Transactional
//    public List<Client> findById(Long client_id) {
//        return clientRepository.findById(client_id);
//    }
    }


