package com.example.reviewservice;

import com.example.reviewservice.domain.Review;
import com.example.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReviewServiceApplication implements CommandLineRunner {
    @Autowired
    ReviewService reviewService;

    public static void main(String[] args) {
        SpringApplication.run(ReviewServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Review review=new Review(1L,"5342342",5,"ashenafi","nice art of writing");
        reviewService.addReview(review);

    }
}
