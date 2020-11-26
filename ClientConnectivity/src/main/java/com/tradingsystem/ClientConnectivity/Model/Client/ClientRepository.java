package com.tradingsystem.ClientConnectivity.Model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository<C> extends JpaRepository<Client,Long> {


    List<Client> findByName(String name);
    List<Client> findAll();


}
