package com.tradingsystem.ExchangeConnectivity;

public class ExchangeOrder {
<<<<<<< HEAD


    private String product;
    private String quantity;
    private String price;
    private String side;

    //constructors
    public ExchangeOrder(String product, String quantity, String price, String side) {
=======
    String id;
    String product;
    int quantity;
    double price;
    String side;

    public ExchangeOrder() {
    }

    public ExchangeOrder(String product, int quantity, double price, String side) {
>>>>>>> 459adb4bc26e3858eb17bde0802af05677be4e39
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.side = side;
    }

<<<<<<< HEAD
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

=======
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

>>>>>>> 459adb4bc26e3858eb17bde0802af05677be4e39
    public String getSide() {
        return side;
    }

<<<<<<< HEAD
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

=======
    public void setSide(String side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "ExchangeOrder [id=" + id + ", price=" + price + ", product=" + product + ", quantity=" + quantity
                + ", side=" + side + "]";
    }
    
}
>>>>>>> 459adb4bc26e3858eb17bde0802af05677be4e39
