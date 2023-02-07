package com.example.borrowingsservice.integration;


import com.example.borrowingsservice.service.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerMessage {
   private String operationType;
   private CustomerDTO customerDTO;
}
