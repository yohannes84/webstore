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

}
