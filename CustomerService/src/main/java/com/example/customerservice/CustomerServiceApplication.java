package com.example.customerservice;

import com.example.customerservice.service.CustomerDTO;
import com.example.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableKafka
public class CustomerServiceApplication implements CommandLineRunner {
    @Autowired
    CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CustomerDTO customerDTO=new CustomerDTO(1L,"ashenafi","0912330012","ahsenfi@gmail.com");
        customerService.addCustomer(customerDTO);
    }
}
/***
 * To do
 * config server
 *        what to store in config server
 * kafka server
 *       starting kafka and sending to message
 *       sending object
 * zipkin server
 */
