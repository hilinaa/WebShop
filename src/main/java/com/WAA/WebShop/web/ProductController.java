package com.WAA.WebShop.web;

import com.WAA.WebShop.data.OrderRepository;
import com.WAA.WebShop.domain.Order;
import com.WAA.WebShop.domain.Product;
import com.WAA.WebShop.service.ProductDTO;
import com.WAA.WebShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(@RequestParam(value="name",required = false) String name){
        Collection<ProductDTO> productDTOs = productService.findAll();

        Products products = new Products();
        if(name==null){
             products.setProducts(productDTOs);
        }
        else{
            Collection<ProductDTO> productDTOsSearch = productService.search(name);
            products.setProducts(productDTOsSearch);
        }

       if(productDTOs.size()==0){
           return new ResponseEntity<CustomErrorType>(new CustomErrorType("No Products Found"),HttpStatus.NOT_FOUND);
       }
        return new ResponseEntity<Products>(products,HttpStatus.OK);
    }
//    @GetMapping("/products")
//    public ResponseEntity<?> searchProduct(@RequestParam(value="name") String name){
//        Collection<ProductDTO> productDTOs = productService.search(name);
//        Products products = new Products();
//        products.setProducts(productDTOs);
//        if(productDTOs.size()==0){
//            return new ResponseEntity<CustomErrorType>(new CustomErrorType("No Products Found"),HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Products>(products,HttpStatus.OK);
//    }
    @GetMapping("/products/{productNumber}")
    public ResponseEntity<?> getOneProduct(@PathVariable String productNumber){
        ProductDTO productDTO = productService.findByProductNumber(productNumber);
        if (productDTO == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with product number " + productNumber + " is not available"),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDTO productDTO){
        productService.add(productDTO);
        ProductDTO productDTO1 = productService.findByProductNumber(productDTO.getProductNumber());
        return new ResponseEntity<ProductDTO>(productDTO1,HttpStatus.OK);
    }
    @PutMapping("/products/{productNumber}")
    public ResponseEntity<?> UpdateProduct(@PathVariable String productNumber, @Valid @RequestBody ProductDTO productDTO){
        ProductDTO product = productService.findByProductNumber(productNumber);
        if (product == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with product number= " + productNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        productService.update(productDTO);
        return new ResponseEntity<ProductDTO>(product,HttpStatus.OK);
    }
    @DeleteMapping ("/products/{productNumber}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productNumber){
        ProductDTO product = productService.findByProductNumber(productNumber);
        if (product == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product with product number " + productNumber + " is not available"),HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(productNumber);
        return new ResponseEntity<ProductDTO>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/orders")
    public ResponseEntity<?> addOrder(@RequestBody Order order){
        orderRepository.save(order);
        return new ResponseEntity<Order>(order,HttpStatus.OK);
    }
    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders(){
        Collection<Order> orders = orderRepository.findAll();

        Orders orders1 = new Orders();
        orders1.setOrders(orders);


        if(orders.size()==0){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("No orders Found"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Orders>(orders1,HttpStatus.OK);
    }
}
