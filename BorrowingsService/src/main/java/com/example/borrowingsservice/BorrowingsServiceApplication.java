package com.example.borrowingsservice;

import com.example.borrowingsservice.domain.Borrowings;
import com.example.borrowingsservice.service.BorrowingsService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BorrowingsServiceApplication implements CommandLineRunner {
    @Autowired
    BorrowingsService borrowingsService;

    public static void main(String[] args) {
        SpringApplication.run(BorrowingsServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Borrowings borrowings = new Borrowings(1L, LocalDate.now(), 34343L, "ashenafi", "4324235", "the art oc codding");
        borrowingsService.addBorrowings(borrowings);

        borrowings = new Borrowings(21L, LocalDate.now(), 34343L, "ashenafi", "4324235", "the art oc codding");
        borrowingsService.addBorrowings(borrowings);
        System.out.println("2 borrowing added");
    }
}
