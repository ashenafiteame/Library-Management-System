package com.example.reviewservice.service;

import com.example.reviewservice.dao.ReviewRepository;
import com.example.reviewservice.domain.Review;
import com.example.reviewservice.integration.ReviewDTOSender;
import com.example.reviewservice.integration.ReviewMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    ReviewDTOSender reviewDTOSender;
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
        reviewDTOSender.sendCustomerMessage(new ReviewMessage("save",ReviewAdapter.toDTO(review)));
    }

    @Override
    public Optional<Review> getReview(Long reviewId) {
       return reviewRepository.findById(reviewId);
    }

    @Override
    public List<Review> getReviews(String isbn) {

        return reviewRepository.findAllByIsbn(isbn);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}

