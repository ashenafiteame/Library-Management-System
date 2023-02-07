package com.example.bookcommandservice;


import com.example.bookcommandservice.domain.Book;
import com.example.bookcommandservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableDiscoveryClient
@EnableKafka
public class BookCommandServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(BookCommandServiceApplication.class, args);
    }


}
