package com.example.borrowingsservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class BorrowingsDTO {
    private Long borrowingNumber;
    private LocalDate localDate;
    private Long customerNumber;
    private String customerName;
    private String isbn;
    private String title;


}
