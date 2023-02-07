package com.example.reviewservice.service;

import com.example.reviewservice.domain.Review;

import java.util.List;
import java.util.Optional;

public interface IReviewService {
    void addReview(Review review);
    Optional<Review> getReview(Long reviewId);
    List<Review> getReviews(String isbn);

    List<Review> getAllReviews();
}
