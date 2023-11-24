package com.example.pms.domain;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    private long cardNumber;
    private String cardType;
    private String expirationDate;
    private int cvc;
}
