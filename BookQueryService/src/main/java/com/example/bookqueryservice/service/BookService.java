package com.example.bookqueryservice.service;

import com.example.bookqueryservice.dao.BookRepository;
import com.example.bookqueryservice.domain.BookQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
   private BookRepository bookRepository;
    public void add(BookQuery book) {
        bookRepository.save(book);
    }
    public void update(BookQuery book) {
        bookRepository.save(book);
    }
    public void delete(BookQuery book) {
        bookRepository.deleteById(book.getIsbn());
    }
    @Override
    public List<BookQuery> getAllBooks() {
       return  bookRepository.findAll();

    }

    @Override
    public Optional<BookQuery> getBook(String isbn) {

       return bookRepository.findById(isbn);


    }

    @Override
    public void updateBook(BookDTO bookDTO) {
        bookRepository.save(BookAdapter.fromDTO(bookDTO));
    }

    @Override
    public void updateReview(ReviewDTO reviewDTO) {
        Optional<BookQuery> bookQuery=bookRepository.findById(reviewDTO.getIsbn());
        if (bookQuery.isPresent()){
            BookQuery bookQuery1=bookQuery.get();
            bookQuery1.addReview(BookAdapter.fromReviewDTO(reviewDTO));
            bookRepository.save(bookQuery1);
        }
    }

    @Override
    public void addBook(BookDTO bookDTO) {
        bookRepository.save(BookAdapter.fromDTO(bookDTO));
    }


}
