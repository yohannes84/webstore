package com.example.pms.domain;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private long customerId;
    private String name;
    private String email;
    private String phone;
    private String street;
    private String city;
    private String zip;
}
