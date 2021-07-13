package com.WAA.WebShop.web;

import com.WAA.WebShop.domain.Product;
import com.WAA.WebShop.service.ProductDTO;

import java.util.ArrayList;
import java.util.Collection;

public class Products {
    private Collection<ProductDTO> products =new ArrayList<>();

    public Collection<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductDTO> products) {
        this.products = products;
    }
}
