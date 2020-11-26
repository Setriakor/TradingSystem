package com.tradingsystem.ClientConnectivity.Model.ClientOrder;

import com.tradingsystem.ClientConnectivity.Model.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientOrderRepository<C> extends JpaRepository<ClientOrder,Long> {


   // List<ClientOrder> findByName();
    List<ClientOrder> findAll();
    
}
