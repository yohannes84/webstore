package com.example.pms.web;

import com.example.pms.domain.Product;
import com.example.pms.domain.Review;

import java.util.List;
import java.util.stream.Collectors;


public class ProductMapper {
    public static Product getProduct(ProductDTO productDTO){

        return Product.builder()
                .productNumber(productDTO.getProductNumber())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .noInStock(productDTO.getNoInStock())
                .reviews(productDTO.getReviews().stream()
                        .map(reviewDTO -> Review.builder()
                                .name(reviewDTO.getName())
                                .reviewDate(reviewDTO.getReviewDate())
                                .rating(reviewDTO.getRating())
                                .comment(reviewDTO.getComment())
                                .build()).collect(Collectors.toList()))
                .build();

//        return new Product(
//                productDTO.getProductNumber(),
//                productDTO.getName(),
//                productDTO.getPrice(),
//                productDTO.getDescription(),
//                productDTO.getNumInStock(),
//                mapReviewDTOListToReviewList(productDTO.getReviews())
//        );
    }

    public static ProductDTO getProductDTO(Product product){

        return ProductDTO.builder()
                .productNumber(product.getProductNumber())
                .name(product.getName())
                .description(product.getDescription())
                .noInStock(product.getNoInStock())
                .price(product.getPrice())
                .reviews(product.getReviews().stream()
                        .map(review -> ReviewDTO.builder()
                        .name(review.getName())
                                .reviewDate(review.getReviewDate())
                                .comment(review.getComment())
                                .rating(review.getRating())
                                .build()).collect(Collectors.toList()))

                .build();

//        return new ProductDTO(
//                product.getProductNumber(),
//                product.getName(),
//                product.getPrice(),
//                product.getDescription(),
//                product.getNumInStock(),
//                mapReviewListToReviewDTOList(product.getReviews())
//        );
    }

    private static List<Review> mapReviewDTOListToReviewList(List<ReviewDTO> reviewDTOList) {
        return reviewDTOList.stream()
                .map(ProductMapper::mapReviewDTOToReview)
                .collect(Collectors.toList());
    }

    private static Review mapReviewDTOToReview(ReviewDTO reviewDTO) {
        return new Review(
                reviewDTO.getName(),
                reviewDTO.getRating(),
                reviewDTO.getComment(),
                reviewDTO.getReviewDate()
        );
    }

    private static List<ReviewDTO> mapReviewListToReviewDTOList(List<Review> reviews) {
        return reviews.stream()
                .map(ProductMapper::mapReviewToReviewDTO)
                .collect(Collectors.toList());
    }

    private static ReviewDTO mapReviewToReviewDTO(Review review) {
        return new ReviewDTO(
                review.getName(),
                review.getRating(),
                review.getComment(),
                review.getReviewDate()
        );
    }

}
