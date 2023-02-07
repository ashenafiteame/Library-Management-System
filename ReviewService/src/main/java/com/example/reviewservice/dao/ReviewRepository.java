package com.example.reviewservice.dao;

import com.example.reviewservice.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, Long> {

    List<Review> findAllByIsbn(String isbn);
}
