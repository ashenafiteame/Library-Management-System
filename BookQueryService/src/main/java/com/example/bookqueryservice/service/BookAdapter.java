package com.example.bookqueryservice.service;

import com.example.bookqueryservice.domain.BookQuery;
import com.example.bookqueryservice.domain.Review;

public class BookAdapter {
    public static BookDTO toDTO(BookQuery bookQuery){
        return  new BookDTO(bookQuery.getIsbn(),bookQuery.getTitle(), bookQuery.getDescription(), bookQuery.getAuthorName());
    }

    public static BookQuery fromDTO(BookDTO bookDTO) {
        return  new BookQuery(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getDescription(), bookDTO.getAuthorName());
    }
    public static  ReviewDTO toReviewDTO(Review review){
        return new ReviewDTO(review.getReviewId(), review.getIsbn(), review.getRatting(), review.getCustomerName(), review.getDescription());
    }
    public static Review fromReviewDTO(ReviewDTO reviewDTO){
        return new Review(reviewDTO.getReviewId(), reviewDTO.getIsbn(), reviewDTO.getRatting(), reviewDTO.getCustomerName(), reviewDTO.getDescription());
    }
}
