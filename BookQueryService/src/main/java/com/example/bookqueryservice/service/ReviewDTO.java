package com.example.bookqueryservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ReviewDTO {
    private Long reviewId;
    private String isbn;
    private int ratting;
    private String customerName;
    private String description;
}
