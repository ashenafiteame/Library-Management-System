package com.example.bookcommandservice.service;


import com.example.bookcommandservice.domain.Book;

public class BookAdapter {
    public static BookDTO toDTO(Book book) {
        return new BookDTO(book.getIsbn(), book.getTitle(), book.getDescription(), book.getAuthorName());
    }

    public static Book fromDTO(BookDTO bookDTO) {
        return new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getDescription(), bookDTO.getAuthorName());
    }
}
