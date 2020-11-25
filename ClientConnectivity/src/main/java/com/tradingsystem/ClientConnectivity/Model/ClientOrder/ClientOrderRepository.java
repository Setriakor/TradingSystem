package com.tradingsystem.ClientConnectivity.Model.ClientOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrderRepository extends JpaRepository<ClientOrder,Long> {
    
}
