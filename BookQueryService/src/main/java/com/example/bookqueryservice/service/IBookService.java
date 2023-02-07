package com.example.bookqueryservice.service;

import com.example.bookqueryservice.domain.BookQuery;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<BookQuery> getAllBooks();
    Optional<BookQuery> getBook(String isbn);

    void updateBook(BookDTO bookDTO);

    void updateReview(ReviewDTO reviewDTO);

    void addBook(BookDTO bookDTO);
}
