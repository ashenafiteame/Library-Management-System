package com.example.bookqueryservice;

import com.example.bookqueryservice.domain.BookQuery;
import com.example.bookqueryservice.domain.Review;
import com.example.bookqueryservice.integration.BookDTOConsumer;
import com.example.bookqueryservice.service.BookService;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.DelegatingByTypeSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@EnableKafka
public class BookQueryServiceApplication implements CommandLineRunner {
    @Autowired
    BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookQueryServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        BookQuery book = new BookQuery("4535345", "core java", "description 1", "ashenfi" );
        Review review = new Review(44L, book.getIsbn(), 3, "ashenafi", "nice book i enjoyed it");
        book.addReview(review);
        bookService.add(book);
        BookQuery book2 = new BookQuery("7777777777777777", "core java2", "description 2", "ashenfi");
        review = new Review(34L, book2.getIsbn(), 1, "ashenafi", "nice book i dont enjoyed it");
        book2.addReview(review);
        bookService.add(book2);
        System.out.println("2 books added from main");

        System.out.println(bookService.getAllBooks());
    }


}
