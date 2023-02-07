package com.example.customerservice.service;


import com.example.customerservice.domain.Customer;

public class CustomerAdapter {
    public static CustomerDTO toDTO(Customer customer){
        return  new CustomerDTO(customer.getCustomerNumber(),customer.getName(), customer.getPhone(), customer.getEmail());
    }
    public static Customer fromDTO(CustomerDTO customerDTO){
        return new Customer(customerDTO.getCustomerNumber(), customerDTO.getName(), customerDTO.getPhone(), customerDTO.getEmail(), null);
    }
}
