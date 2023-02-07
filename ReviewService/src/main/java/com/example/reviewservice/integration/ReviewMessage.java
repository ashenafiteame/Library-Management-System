package com.example.reviewservice.integration;


import com.example.reviewservice.service.ReviewDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ReviewMessage {
   private String operationType;
   private ReviewDTO reviewDTO;
}
