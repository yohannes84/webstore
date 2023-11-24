package com.example.pms.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document()
public class Product {

    @Id
    private long productNumber;
    private String name;
    private Double price;
    private String description;
    private Integer noInStock;
    private List<Review> reviews;


//    public Product() {
//    }
//
//    public Product(String productNumber, String name, Double price, String description, Integer numInStock, List<Review> reviews) {
//        this.productNumber = productNumber;
//        this.name = name;
//        this.price = price;
//        this.description = description;
//        this.numInStock = numInStock;
//        this.reviews = reviews;
//    }
//
//    public String getProductNumber() {
//        return productNumber;
//    }
//
//    public void setProductNumber(String productNumber) {
//        this.productNumber = productNumber;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Integer getNumInStock() {
//        return numInStock;
//    }
//
//    public void setNumInStock(Integer numInStock) {
//        this.numInStock = numInStock;
//    }
//
//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }
}
