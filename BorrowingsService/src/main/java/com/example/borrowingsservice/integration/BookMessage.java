package com.example.borrowingsservice.integration;



import com.example.borrowingsservice.service.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookMessage {
   private String operationType;
   private BookDTO bookDTO;
}
