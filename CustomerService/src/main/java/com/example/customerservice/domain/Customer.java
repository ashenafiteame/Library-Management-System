package com.example.customerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data @NoArgsConstructor  @AllArgsConstructor
public class Customer {
    @Id
    private Long customerNumber;
    private String name;
    private String phone;
    private String email;
    private Address address;

}
