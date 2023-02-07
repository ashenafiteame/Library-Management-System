package com.example.clientapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class BorrowingsDTO {
    private String isbn;
    private Long customerNumber;


}
