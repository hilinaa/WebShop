package com.WAA.WebShop.service;

import com.mongodb.lang.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProductDTO {
    @NonNull
    private String productNumber;
    @NotEmpty
    @Size(min=2,max=10)
    private String name;
    @NonNull
    private double price;
    @NonNull
    private String description;
    @NonNull
    private int numberInStock;

    public ProductDTO(String productNumber, String name, double price,int numberInStock) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.numberInStock =numberInStock;
        this.description = "No description";
    }
    public ProductDTO(){}
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
