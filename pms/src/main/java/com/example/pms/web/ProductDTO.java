package com.example.pms.web;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {


    private long productNumber;
    private String name;
    private Double price;
    private String description;
    private Integer noInStock;
    private List<ReviewDTO> reviews;

//    public ProductDTO(String productNumber, String name, Double price, String description, Integer numInStock, List<ReviewDTO> reviews) {
//        this.productNumber = productNumber;
//        this.name = name;
//        this.price = price;
//        this.description = description;
//        this.numInStock = numInStock;
//        this.reviews = reviews;
//    }
//
//    public ProductDTO() {
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
//    public List<ReviewDTO> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<ReviewDTO> reviews) {
//        this.reviews = reviews;
//    }


}
