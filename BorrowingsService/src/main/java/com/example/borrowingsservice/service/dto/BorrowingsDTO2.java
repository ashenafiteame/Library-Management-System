package com.example.borrowingsservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class BorrowingsDTO2 {
    private String isbn;
    private Long customerNumber;

}
