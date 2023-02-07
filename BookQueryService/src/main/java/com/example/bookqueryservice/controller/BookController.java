package com.example.bookqueryservice.controller;


import com.example.bookqueryservice.domain.BookQuery;
import com.example.bookqueryservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RefreshScope
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn){
        Optional<BookQuery> bookDTO=bookService.getBook(isbn);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }
    @GetMapping("/book")
    public List<BookQuery> getAllBooks(){
        return bookService.getAllBooks();
    }

}
