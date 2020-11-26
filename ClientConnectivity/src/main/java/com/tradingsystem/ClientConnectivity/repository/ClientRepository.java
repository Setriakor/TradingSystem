package com.tradingsystem.ClientConnectivity.repository;

import com.tradingsystem.ClientConnectivity.Model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository <p> extends CrudRepository <Client, Long>{
    List<Client> findByName(String name);
    List<Client> findAll();

   // void delete(Long client_id);
//  public  void delete(Long client_id);


}
