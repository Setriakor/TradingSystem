package com.tradingsystem.ClientConnectivity.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clientOrders")
public class ClientOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_order_id")
    private int clientOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @Column(name = "product")
    private String product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "side")
    private String side;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private String status;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "clientorder")
    private ExchangeOrder exchangeOrder;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;



    public ClientOrder(){

    }

    public ClientOrder(int clientOrderId, Portfolio portfolio, String product, int quantity, String side, double price, String status, ExchangeOrder exchangeOrder, Client client) {
        this.clientOrderId = clientOrderId;
        this.portfolio = portfolio;
        this.product = product;
        this.quantity = quantity;
        this.side = side;
        this.price = price;
        this.status = status;
        this.exchangeOrder = exchangeOrder;
        this.client = client;
    }

    public int getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(int clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ExchangeOrder getExchangeOrder() {
        return exchangeOrder;
    }

    public void setExchangeOrder(ExchangeOrder exchangeOrder) {
        this.exchangeOrder = exchangeOrder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
