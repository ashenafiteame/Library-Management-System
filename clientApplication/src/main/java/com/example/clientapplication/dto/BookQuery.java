package com.example.clientapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookQuery {
    private String isbn;
    private String title;
    private String description;
    private String authorName;
    private List<ReviewDTO> reviewList=new ArrayList<>();

    public BookQuery(String isbn, String title, String description, String authorName) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.authorName = authorName;
        this.reviewList=new ArrayList<>();
    }

    public void addReview(ReviewDTO review){
        this.reviewList.add(review);
    }
    public void deleteReview(ReviewDTO review){
       this.reviewList.remove(review);
    }

    @Override
    public String toString() {
        return "BookQuery{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authorName='" + authorName + '\'' +
                ", reviewList=" + reviewList +
                '}';
    }
}
