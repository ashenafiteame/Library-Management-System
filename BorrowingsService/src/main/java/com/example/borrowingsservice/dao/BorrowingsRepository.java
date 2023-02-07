package com.example.borrowingsservice.dao;

import com.example.borrowingsservice.domain.Borrowings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.LabelUI;
import java.util.List;

@Repository
public interface BorrowingsRepository extends MongoRepository<Borrowings,Long> {
    List<Borrowings> findBorrowingsByCustomerNumber(Long customerNumber);
    Borrowings findBorrowingsByIsbn(String isbn);


}
