package com.example.bookqueryservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookDTO {
    private String isbn;
    private String title;
    private String description;
    private String authorName;
}
