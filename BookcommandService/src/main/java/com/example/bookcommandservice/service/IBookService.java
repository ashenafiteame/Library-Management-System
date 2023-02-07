package com.example.bookcommandservice.service;

import com.example.bookcommandservice.domain.Book;

public interface IBookService {
    void add(BookDTO book);

    void update(BookDTO book);

    void delete(String isbn);
}
