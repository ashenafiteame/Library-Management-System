package com.example.bookqueryservice.integration;


import com.example.bookqueryservice.service.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookMessage {
   private String operationType;
   private BookDTO bookDTO;
}
