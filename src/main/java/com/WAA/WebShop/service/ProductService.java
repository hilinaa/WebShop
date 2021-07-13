package com.WAA.WebShop.service;


import com.WAA.WebShop.data.ProductRepository;
import com.WAA.WebShop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void add(ProductDTO productDTO){
        Product product = ProductAdopter.getProduct(productDTO);
        productRepository.save(product);
    }
    public void update(ProductDTO productDTO){
        Product product = ProductAdopter.getProduct(productDTO);
        productRepository.save(product);
    }
    public ProductDTO findByProductNumber(String productNumber){
        Product product = productRepository.findProductByProductNumber(productNumber);
        if(product==null){
            return null;
        }
       return ProductAdopter.getProductDTO(product);
    }
    public Collection<ProductDTO> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        if(products.size()!=0) {
            for (Product product : products) {
                productDTOS.add(ProductAdopter.getProductDTO(product));
            }
        }
        return productDTOS;
    }
    public Collection<ProductDTO> search(String name){
        List<Product> products = productRepository.findProductsByNameLike(name);
        List<ProductDTO> productDTOS = new ArrayList<>();
        if(products.size()!=0) {
            for (Product product : products) {
                productDTOS.add(ProductAdopter.getProductDTO(product));
            }
        }
        return productDTOS;
    }
    public void deleteProduct(String productNumber){
        productRepository.deleteById(productNumber);
    }
}
