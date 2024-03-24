package com.spasov.homework4.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends Entity{
    private Date dateOrder;
    private List<Product> productsList;

    public Order() {
        super();
    }

    public Order(long id, Date dateOrder, List<Product> productsList) {
        super(id);
        this.dateOrder = dateOrder;
        this.productsList = productsList;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                "dateOrder=" + dateOrder +
                ", productsList=" + productsList +
                '}';
    }
}
