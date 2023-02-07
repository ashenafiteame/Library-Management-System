package com.example.bookqueryservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data @NoArgsConstructor @AllArgsConstructor
public class BookQuery {
    @Id
    private String isbn;
    private String title;
    private String description;
    private String authorName;
    private List<Review> reviewList=new ArrayList<>();

    public BookQuery(String isbn, String title, String description, String authorName) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.authorName = authorName;
        this.reviewList=new ArrayList<>();
    }

    public void addReview(Review review){
        this.reviewList.add(review);
    }
    public void deleteReview(Review review){
       this.reviewList.remove(review);
    }


}
