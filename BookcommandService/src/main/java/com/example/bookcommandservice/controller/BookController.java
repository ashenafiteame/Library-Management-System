package com.example.bookcommandservice.controller;

import com.example.bookcommandservice.domain.Book;
import com.example.bookcommandservice.service.BookDTO;
import com.example.bookcommandservice.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;


    @PostMapping("/bookcommand")
    public void putBook(@RequestBody BookDTO book) {
        bookService.add(book);
    }

    @PutMapping("/bookcommand")
    public void updateBook(@RequestBody BookDTO book) {
        bookService.update(book);
    }

    @DeleteMapping("/bookcommand/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
        bookService.delete(isbn);
    }

///for testing

    @GetMapping("/book")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
