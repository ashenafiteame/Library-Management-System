package com.example.customerservice.integration;

import com.example.customerservice.service.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerMessage {
   private String operationType;
   private CustomerDTO customerDTO;
}
