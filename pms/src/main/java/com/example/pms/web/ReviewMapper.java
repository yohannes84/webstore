package com.example.pms.web;

import com.example.pms.domain.Review;


public class ReviewMapper {

    public static ReviewDTO getReviewDTO(Review review) {
        return ReviewDTO.builder()
                .name(review.getName())
                .rating(review.getRating())
                .comment(review.getComment())
                .build();

//        ReviewDTO reviewDTO = new ReviewDTO();
//        reviewDTO.setName(review.getName());
//        reviewDTO.setRating(review.getRating());
//        reviewDTO.setComment(review.getComment());
//        reviewDTO.setReviewDate(review.getReviewDate());
//        return reviewDTO;
    }

    public static Review getReview(ReviewDTO reviewDTO) {
        return Review.builder()
                .name(reviewDTO.getName())
                .rating(reviewDTO.getRating())
                .comment(reviewDTO.getComment())
                .build();

//        Review review = new Review();
//        review.setName(reviewDTO.getName());
//        review.setRating(reviewDTO.getRating());
//        review.setComment(reviewDTO.getComment());
//        review.setReviewDate(reviewDTO.getReviewDate());
//        return review;
    }
}
