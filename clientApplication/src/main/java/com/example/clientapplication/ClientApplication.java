package com.example.clientapplication;

import com.example.clientapplication.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {
    @Autowired
    @Lazy
    RestTemplate restTemplate;


    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //1 Add 2 customers to the customer service

        CustomerDTO customerDTO = new CustomerDTO(11L, "Jhon", "55555555", "jhon1@gmail.com");
        restTemplate.postForLocation("http://localhost:8080/customer", customerDTO);
        System.out.println("\n********* ADDING CUSTOMER 1 ********** \n"+customerDTO.toString());

        CustomerDTO customerDTO2 = new CustomerDTO(12L, "Ashenafi", "453666666234", "ashenafi@gmail.com");
        restTemplate.postForLocation("http://localhost:8080/customer", customerDTO2);
        System.out.println("\n********* ADDING CUSTOMER 2 ********** \n"+customerDTO2.toString());

        //2 Add 2 books to the bookcommand service
        BookDTO book = new BookDTO("55555555555", "core java", "description 1", "Ashenfi");
        restTemplate.postForLocation("http://localhost:8080/bookcommand", book);
        System.out.println("\n********* ADDING BOOK 1 ********** \n"+book.toString());

        BookDTO book2 = new BookDTO("6666666666", "core SQL", "description 2", "Marry");
        restTemplate.postForLocation("http://localhost:8080/bookcommand", book2);

        System.out.println("\n********* ADDING BOOK 2 ********** \n"+book2.toString());

        //3 Add 2 reviews for every book in the review service, one review per customer

        ReviewDTO review = new ReviewDTO(11L, "55555555555", 5, "Jhon1", "nice art of writing");
        restTemplate.postForLocation("http://localhost:8080/review", review);
        review = new ReviewDTO(12L, "55555555555", 1, "ashenafi", "bad art of writing");
        restTemplate.postForLocation("http://localhost:8080/review", review);


        review = new ReviewDTO(13L, "6666666666", 4, "Jhon1", "good art of writing");
        restTemplate.postForLocation("http://localhost:8080/review", review);
        review = new ReviewDTO(14L, "6666666666", 3, "ashenafi", "not bad art of writing");
        restTemplate.postForLocation("http://localhost:8080/review", review);

        System.out.println("\n*********  2 reviews per book added from client service ********* ");


        //4 Get all books from the booksquery service with all the information of the books and  print it to the console

        BookQuery[] bookDTOs = restTemplate.getForObject("http://localhost:8080/book", BookQuery[].class);
        for (BookQuery b : bookDTOs
        ) {
            System.out.println(b.toString());

        }

        //5 Add a borrowing to the borrowingservice for a book and a customer
        BorrowingsDTO borrowingsDTO = new BorrowingsDTO("55555555555", 11L);
        restTemplate.postForLocation("http://localhost:8080/borrowings", borrowingsDTO);

        BorrowingsDTO borrowingsDTO2 = new BorrowingsDTO("6666666666", 11L);
        restTemplate.postForLocation("http://localhost:8080/borrowings", borrowingsDTO2);
        System.out.println("\n********* 2 borrowings added *********  ");

        //Change the title of this book that is borrowed
        String isbn= borrowingsDTO.getIsbn();
        BookQuery borrowedBook =  restTemplate.getForObject("http://localhost:8080/book/"+isbn, BookQuery.class);
        System.out.println(borrowedBook.toString());

        borrowedBook.setTitle("new title");
        restTemplate.postForLocation("http://localhost:8080/bookcommand", AdapterClass.toDTO(borrowedBook));
        System.out.println("\n*********  borrowed book title changed ********* ");



        //Get this book from the booksquery service and check if the title has changed
        BookQuery updatedBorrowedBook =  restTemplate.getForObject("http://localhost:8080/book/"+isbn, BookQuery.class);
        System.out.println(updatedBorrowedBook.toString());



        //Get the corresponding borrowing and check if the book title has changed
        System.out.println("\n*********  book from the borrowing service ********* ");

        Borrowings borrowings= restTemplate.getForObject("http://localhost:8080/borrowings/isbn/"+isbn, Borrowings.class);
        System.out.println(borrowings);




    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
