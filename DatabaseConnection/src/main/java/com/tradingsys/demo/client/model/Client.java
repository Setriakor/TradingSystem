package com.tradingsys.demo.client.model;

////importing necessary libraries
//import com.turntabl.Client_Connectivity.portfolio.model.Portfolio;
//import com.turntabl.Client_Connectivity.stockrecord.model.StockRecord;

import com.tradingsys.demo.clientorder.model.ClientOrder;
import com.tradingsys.demo.portfolio.model.Portfolio;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "\"client\"")
public class Client implements Serializable {

    //user class attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "email", length = 200)
    private String email;

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "location")
    private String location;

    @Column(name = "balance")
    private  double balance;

    @Column(name = "created_date")
    private Timestamp created_date;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<Portfolio> portfolios;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<ClientOrder> clientOrders;



    public Client() {
    }

    public Client(Long userId, String name, String email, String password, String location, double balance, Timestamp created_date )/*List<Portfolio> portfolios, List<ClientOrder> clientOrders*/ {
        clientId = clientId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.location = location;
        this.balance = balance;
        this.created_date = created_date;
//        this.portfolios = portfolios;
//        this.clientOrders = clientOrders;
    }

    public Long clientId() {
        return clientId;
    }

    public void setUserId(Long clientId) {
        clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public void addPortfolio(Portfolio portfolio){
        this.portfolios.add(portfolio);
    }

//    public List<Portfolio> getPortfolios() {
//        return portfolios;
//    }
//
//    public void setPortfolios(List<Portfolio> portfolios) {
//        this.portfolios = portfolios;
//    }
//
//    public List<ClientOrder> getClientOrders() {
//        return clientOrders;
//    }
//
//    public void setClientOrders(List<ClientOrder> clientOrders) {
//        this.clientOrders = clientOrders;
//    }
}
