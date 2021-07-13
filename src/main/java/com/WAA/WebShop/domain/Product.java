package com.WAA.WebShop.domain;

import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

    @Id
    private String productNumber;
    private String name;
    private double price;
    private String description;
    private int numberInStock;

    public Product(String productNumber, String name, double price,int numberInStock) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.numberInStock =numberInStock;
        this.description = "No description";
    }
    public Product(){}
    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }
}
