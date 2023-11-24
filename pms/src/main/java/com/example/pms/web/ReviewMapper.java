package com.example.pms.web;

import com.example.pms.domain.Review;


public class ReviewMapper {

    public static ReviewDTO getReviewDTO(Review review) {
        return ReviewDTO.builder()
                .name(review.getName())
                .rating(review.getRating())
                .comment(review.getComment())
                .build();
    }

    public static Review getReview(ReviewDTO reviewDTO) {
        return Review.builder()
                .name(reviewDTO.getName())
                .rating(reviewDTO.getRating())
                .comment(reviewDTO.getComment())
                .build();
    }
}
