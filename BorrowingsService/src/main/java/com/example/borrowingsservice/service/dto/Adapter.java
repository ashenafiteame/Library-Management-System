package com.example.borrowingsservice.service.dto;

import com.example.borrowingsservice.domain.Borrowings;

import java.time.LocalDate;
import java.util.Date;

public class Adapter {
    public static BorrowingsDTO toBorrowingsDTO(Borrowings borrowings){
        return new BorrowingsDTO(
                borrowings.getBorrowingNumber(),
                borrowings.getLocalDate(),
                borrowings.getCustomerNumber(),
                borrowings.getCustomerName(),
                borrowings.getIsbn(),
                borrowings.getTitle());
    }
    public static Borrowings fromBorrowingsDTO(BorrowingsDTO borrowings){
        return new Borrowings( borrowings.getBorrowingNumber(),
                borrowings.getLocalDate(),
                borrowings.getCustomerNumber(),
                borrowings.getCustomerName(),
                borrowings.getIsbn(),
                borrowings.getTitle());
    }
}
