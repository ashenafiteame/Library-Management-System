package com.example.reviewservice.service;



import com.example.reviewservice.domain.Review;

public class ReviewAdapter {
    public static ReviewDTO toDTO(Review review){
        return  new ReviewDTO(review.getReviewId(),review.getIsbn(),review.getRatting(),review.getCustomerName(),review.getDescription());
    }
    public static Review fromDTO(ReviewDTO reviewDTO){
        return new Review(reviewDTO.getReviewId(),reviewDTO.getIsbn(),reviewDTO.getRatting(),reviewDTO.getCustomerName(),reviewDTO.getDescription());
    }
}
