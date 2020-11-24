package com.tradingsystem.ExchangeConnectivity;

public class ExchangeOrder {
    String id;
    String product;
    int quantity;
    double price;
    String side;

    public ExchangeOrder() {
    }

    public ExchangeOrder(String product, int quantity, double price, String side) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "ExchangeOrder [id=" + id + ", price=" + price + ", product=" + product + ", quantity=" + quantity
                + ", side=" + side + "]";
    }
    
}
