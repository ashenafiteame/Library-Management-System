package com.example.borrowingsservice.service;

import com.example.borrowingsservice.domain.Borrowings;
import com.example.borrowingsservice.service.dto.BookDTO;
import com.example.borrowingsservice.service.dto.BorrowingsDTO;
import com.example.borrowingsservice.service.dto.BorrowingsDTO2;
import com.example.borrowingsservice.service.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface IBorrowingsService {


    void addBorrowings(Borrowings borrowings);

    Optional<Borrowings> getBorrowing(Long borrowingId);

    List<Borrowings> getBorrowings();

    void updateBorrowings(Borrowings borrowings);



    void updateBorrowingsCustomer(CustomerDTO customerDTO);

    void updateBorrowingsBook(BookDTO bookDTO);

    void deleteBorrowings(Long borrowingId);


    void addBorrowing(BorrowingsDTO2 borrowingsDTO);

    Borrowings getBorrowingByIsbn(String isbn);

    void updateBorrowingsfromBook(BookDTO bookDTO);
}
