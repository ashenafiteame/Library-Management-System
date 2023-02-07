package com.example.customerservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerDTO {
    private Long customerNumber;
    private String name;
    private String phone;
    private String email;
}