package com.example.clientapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Data @NoArgsConstructor @AllArgsConstructor
public class Borrowings {

    private Long borrowingNumber;
    private Date date;
    private Long customerNumber;
    private String customerName;
    private String isbn;
    private String bookTitle;
}
