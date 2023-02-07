package com.example.customerservice.controller;


import com.example.customerservice.service.CustomerDTO;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @GetMapping("/customer/{customerNumber}")
    public Optional<CustomerDTO> getCustomer(@PathVariable Long customerNumber) {
       Optional<CustomerDTO> c = customerService.getCustomer(customerNumber);
        return customerService.getCustomer(customerNumber);
    }

    @PostMapping("/customer")
    public void putCustomer(@RequestBody CustomerDTO customer) {
        customerService.addCustomer(customer);
    }

    @PutMapping("/customer")
    public void updateCustomer(@RequestBody CustomerDTO customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/{customerNumber}")
    public void deleteCustomer(@PathVariable Long customerNumber) {
        customerService.deleteCustomer(customerNumber);
    }


}
