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
}
