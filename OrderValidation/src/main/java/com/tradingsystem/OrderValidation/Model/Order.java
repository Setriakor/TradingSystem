package com.tradingsystem.OrderValidation.Model;

public class Order {
    String product;
    int quantity;
    double price;
    String clientID;
    String portfolioID;
    String status;

    public Order() {
    }

    public Order(String product, int quantity, double price, String clientID, String portfolioID, String status) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.clientID = clientID;
        this.portfolioID = portfolioID;
        this.status = status;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(String portfolioID) {
        this.portfolioID = portfolioID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
