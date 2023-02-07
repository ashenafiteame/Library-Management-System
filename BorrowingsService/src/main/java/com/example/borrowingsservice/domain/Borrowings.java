package com.example.borrowingsservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document
@Data @NoArgsConstructor @AllArgsConstructor
public class Borrowings {
    @Id
    private Long borrowingNumber;
    private LocalDate localDate;
    private Long customerNumber;
    private String customerName;
    private String isbn;
    private String title;
}
