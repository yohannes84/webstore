package com.example.pms.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document()
public class Customer {

    @Id
    private long customerId;
    private String name;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String zip;
}
