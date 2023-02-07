package com.example.reviewservice.controller;

import com.example.reviewservice.domain.Review;
import com.example.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/review")
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }

    @GetMapping("/review")
    public List<Review> addReview(){
        return reviewService.getAllReviews();
    }
    @GetMapping("/review/{reviewId}")
    public Optional<Review> getReview(@PathVariable Long reviewId){
        return reviewService.getReview(reviewId);
    }

    @GetMapping("/reviews/{isbn}")
    public List<Review> getReviews(@PathVariable String isbn){
        return reviewService.getReviews(isbn);
    }
}
