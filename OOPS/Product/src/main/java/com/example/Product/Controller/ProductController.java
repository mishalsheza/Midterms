package com.example.Product.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.Product.models.Product;
import com.example.Product.service.ProductServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class ProductController {
    private ProductServices productServices; 
    public ProductController(ProductServices productServices){
        this.productServices= productServices;
    }
    @GetMapping("/products")
    public Product[] getCart() {
        return null;
    }
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id")Long id) {
        return productServices.getSingleProduct(id);
    }
    
    @PatchMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id){
        return productServices.updateProduct(id);
    }
    @DeleteMapping("products/{id}")
    public Product deleteProduct(@PathVariable("id") Long id){
        return productServices.deleteProduct(id);
    }
}
