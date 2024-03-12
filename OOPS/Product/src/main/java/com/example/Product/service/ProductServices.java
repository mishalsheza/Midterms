package com.example.Product.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Product.dto.ProductDto;
import com.example.Product.models.Product;

@Service

public class ProductServices implements serviceInterface{
    private RestTemplate restTemplate= new RestTemplate();

    @Override
    public Product getSingleProduct(Long id){
        ProductDto abc=restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductDto.class);

        Product product=new Product();
        product.setId(abc.getId());
        product.setCategory(abc.getCategory());
        product.setDescription(abc.getDescription());
        product.setImageUrl(abc.getImage());
        product.setPrice(abc.getPrice());
        product.setPrice(abc.getPrice());

        return product;
    }
    @Override
    public Product[] getCart(){
	ResponseEntity<Product[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products",Product[].class);
	Product[] allProducts = response.getBody();
	return allProducts;
    }
    @Override
    public Product updateProduct(Long id) {
        Product product = getSingleProduct(id);
        ProductDto newprod = new ProductDto();

        newprod.setId(product.getId());
        newprod.setTitle(product.getTitle());
        newprod.setPrice(product.getPrice());
        newprod.setCategory(product.getCategory());
        newprod.setDescription(product.getDescription());
        newprod.setImage(product.getImageUrl());

        restTemplate.put("https:/fakestoreapi.com/product/" + id, newprod);
        return product;
    }
    public Product deleteProduct(Long id) {
        Product delProd = getSingleProduct(id);
        restTemplate.delete("https:/fakestoreapi.com/product/" + id);
        return delProd;
    }
   
}