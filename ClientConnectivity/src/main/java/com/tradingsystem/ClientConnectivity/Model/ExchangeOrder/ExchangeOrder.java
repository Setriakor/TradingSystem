package com.tradingsystem.ClientConnectivity.Model.ExchangeOrder;

import javax.persistence.*;

import com.tradingsystem.ClientConnectivity.Model.ClientOrder.ClientOrder;

import java.io.Serializable;

@Entity
@Table(name = "exchangeOrders")
public class ExchangeOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "exchange_order_id")
    private int exchangeOrderId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_order_id", nullable = false)
    private ClientOrder clientorder;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "side")
    private String side;

    @Column(name = "price")
    private double price;

    @Column(name = "product")
    private String product;



    public ExchangeOrder(){}

    public ExchangeOrder(int exchangeOrderId, ClientOrder clientorder, int quantity, String side, double price, String product) {
        this.exchangeOrderId = exchangeOrderId;
        this.clientorder = clientorder;
        this.quantity = quantity;
        this.side = side;
        this.price = price;
        this.product = product;
    }

    public int getExchangeOrderId() {
        return exchangeOrderId;
    }

    public void setExchangeOrderId(int exchangeOrderId) {
        this.exchangeOrderId = exchangeOrderId;
    }

    public ClientOrder getClientorder() {
        return clientorder;
    }

    public void setClientorder(ClientOrder clientorder) {
        this.clientorder = clientorder;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}