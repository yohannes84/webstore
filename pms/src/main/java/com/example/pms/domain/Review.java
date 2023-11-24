package com.example.pms.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private String name;
    private Double rating;
    private String comment;
    private LocalDateTime reviewDate;

}
