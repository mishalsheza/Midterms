package com.example.Product.models;

//yeh hai apna MODEL.
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String imageUrl;
}