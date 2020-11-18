package com.tradingsystem.ExchangeConnectivity;

public class ExchangeOrder {


    private String product;
    private String quantity;
    private String price;
    private String side;

    //constructors
    public ExchangeOrder(String product, String quantity, String price, String side) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(String quantity) {
        this.quantity= quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSide(String side) {
        this.side = side;
    }



    public String getProduct() {
        return product;
    }
    public String getquantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getSide() {
        return side;
    }

    //    @Override
//    public String toString() {
//        return "ExchangeOrder{" +
//                "product='" + product + '\'' +
//                ", quantity='" + quantity + '\'' +
//                ", price=" + price +
//                ", side='" + side + '\'' +
//
//                '}';
//    }
}

