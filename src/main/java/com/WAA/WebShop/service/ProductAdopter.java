package com.WAA.WebShop.service;

import com.WAA.WebShop.domain.Product;

public class ProductAdopter {

    public static Product getProduct(ProductDTO productDTO){
        Product product = new Product();
        if(productDTO != null){
            product = new Product(productDTO.getProductNumber(),productDTO.getName(),productDTO.getPrice(),productDTO.getNumberInStock());
        }
        return product;
    }

    public static ProductDTO getProductDTO(Product product){
        ProductDTO productDTO =new ProductDTO();
        if(product!=null){
            productDTO = new ProductDTO(product.getProductNumber(),product.getName(),product.getPrice(),product.getNumberInStock());
        }
        return productDTO;
    }
}
