package com.example.customerservice.service;

import com.example.customerservice.dao.CustomerRepository;
import com.example.customerservice.domain.Customer;
import com.example.customerservice.integration.CustomerDTOSender;
import com.example.customerservice.integration.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerDTOSender sender;
    @Autowired
CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers=  customerRepository.findAll();
        List<CustomerDTO> customerDTOS=customers.stream().map(customer -> CustomerAdapter.toDTO(customer)).collect(Collectors.toList());
        return customerDTOS;
    }

    @Override
    public Optional<CustomerDTO> getCustomer(Long customerNumber) {
        Optional<Customer> c= customerRepository.findById(customerNumber);
        return Optional.of(CustomerAdapter.toDTO(c.get()));
    }

    @Override
    public void addCustomer(CustomerDTO customer) {
        customerRepository.save(CustomerAdapter.fromDTO(customer));
        sender.sendCustomerMessage(new CustomerMessage("save",customer));
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {
        customerRepository.save(CustomerAdapter.fromDTO(customer));
       // sender.send("userTopic",customerDTO);
    }

    @Override
    public void deleteCustomer(Long customerNumber) {
        customerRepository.deleteById(customerNumber);
       //sender.send("userTopic",CustomerAdapter.toDTO(customer));
    }

}
