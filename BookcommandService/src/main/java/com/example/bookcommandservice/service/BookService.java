package com.example.bookcommandservice.service;

import com.example.bookcommandservice.dao.BookRepository;
import com.example.bookcommandservice.domain.Book;
import com.example.bookcommandservice.integration.BookDTOSender;
import com.example.bookcommandservice.integration.BookMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
   private BookRepository bookRepository;
    @Autowired
    BookDTOSender sender;
    public void add(BookDTO book) {
        bookRepository.save(BookAdapter.fromDTO(book));
       sender.sendBookMessage(new BookMessage("save",book));
    }
    public void update(BookDTO book) {
        bookRepository.save(BookAdapter.fromDTO(book));
        sender.sendBookMessage(new BookMessage("update",book));

    }
    public void delete(String isbn) {
       Optional<Book> book= bookRepository.findById(isbn);
       if (book.isPresent()){
           bookRepository.deleteById(isbn);

           sender.sendBookMessage(new BookMessage("delete",BookAdapter.toDTO(book.get())));
       }


    }

    public List<Book> getAllBooks() {
        List<Book> books= bookRepository.findAll();
        return books;
    }
}
