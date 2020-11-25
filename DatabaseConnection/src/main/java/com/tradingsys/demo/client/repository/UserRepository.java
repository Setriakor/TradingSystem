package com.tradingsys.demo.client.repository;

//importing necessary libraries

import com.tradingsys.demo.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//class extends spring data jpa to store and retrieve data in a relational database(postgres)
public interface UserRepository extends JpaRepository<Client, Long> {
    //defining findByEmail(String email) method which returns User object as available or not available.
    Optional<Client> findByEmail(String email);

}
