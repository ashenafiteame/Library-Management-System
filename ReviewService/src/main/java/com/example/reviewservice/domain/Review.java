package com.example.reviewservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data @NoArgsConstructor @AllArgsConstructor
public class Review {
    @Id
    private Long reviewId;
    private String isbn;
    private int ratting;
    private String customerName;
    private String description;
}
