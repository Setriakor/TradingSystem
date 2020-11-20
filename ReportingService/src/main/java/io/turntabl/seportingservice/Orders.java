package io.turntabl.seportingservice;

import java.time.LocalDate;

public class Orders {
    public enum orderStatus {
        PENDING, CANCELLED, EXECUTED;
    }
    private  int id;
    private  String product;
    private  int quantity;
    private  double price;
    private int portfolio;
    private LocalDate createDate;
    private orderStatus orderStatus;

    public Orders( int id, String product, int quantity, double price, int portfolio, LocalDate createDate, orderStatus OrderStatus) {
        this.id=id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.portfolio = portfolio;
        this.createDate = createDate;
        this.orderStatus = OrderStatus.PENDING;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getPortfolio() {
        return portfolio;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Orders.orderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPortfolio(int portfolio) {
        this.portfolio = portfolio;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setOrderStatus(Orders.orderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "orders{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", portfolio=" + portfolio +
                ", createDate=" + createDate +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
