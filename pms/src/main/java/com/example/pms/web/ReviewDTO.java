package com.example.pms.web;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
//
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private String name;
    private Double rating;
    private String comment;
    private LocalDateTime reviewDate;

//    public ReviewDTO(String name, Double rating, String comment, LocalDateTime reviewDate) {
//        this.name = name;
//        this.rating = rating;
//        this.comment = comment;
//        this.reviewDate = reviewDate;
//    }
//
//    public ReviewDTO() {
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
//    public Double getRating() {
//        return rating;
//    }
//
//    public void setRating(Double rating) {
//        this.rating = rating;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public LocalDateTime getReviewDate() {
//        return reviewDate;
//    }
//
//    public void setReviewDate(LocalDateTime reviewDate) {
//        this.reviewDate = reviewDate;
 //   }
}
