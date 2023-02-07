package com.example.bookcommandservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data @NoArgsConstructor @AllArgsConstructor
public class Book {
    @Id
    private String isbn;
    private String title;
    private String description;
    private String authorName;

}
