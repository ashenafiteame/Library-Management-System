package com.example.customerservice.service;

import com.example.customerservice.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<CustomerDTO> getAllCustomers();
    Optional<CustomerDTO> getCustomer(Long customerNumber);

    void addCustomer(CustomerDTO customer);

    void updateCustomer(CustomerDTO customer);

    void  deleteCustomer(Long customerNumber);

}
