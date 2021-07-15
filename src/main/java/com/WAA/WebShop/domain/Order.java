package com.WAA.WebShop.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Order {
    @Id
    private int orderId;
    private List<Product> products;
    private PersonInformation personInformation;
    private PaymentInformation paymentInformation;
    private String status;

    public Order(int orderId,Product products, PersonInformation personInformation, PaymentInformation paymentInformation,String status) {
        this.orderId =orderId;
        this.products = new ArrayList<>();
        this.personInformation = personInformation;
        this.paymentInformation = paymentInformation;
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PersonInformation getPersonInformation() {
        return personInformation;
    }

    public void setPersonInformation(PersonInformation personInformation) {
        this.personInformation = personInformation;
    }

    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }
}
