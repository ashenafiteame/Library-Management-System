package com.example.borrowingsservice.controller;

import com.example.borrowingsservice.domain.Borrowings;
import com.example.borrowingsservice.service.BorrowingsService;
import com.example.borrowingsservice.service.dto.BorrowingsDTO;
import com.example.borrowingsservice.service.dto.BorrowingsDTO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BorrowingsController {
    @Autowired
    private BorrowingsService borrowingsService;

    @GetMapping("/borrowings/{borrowingId}")
    public Optional<Borrowings> getBorrowing(@PathVariable Long borrowingId){
        return borrowingsService.getBorrowing(borrowingId);
    }

    @GetMapping("/borrowings/isbn/{isbn}")
    public Borrowings getBorrowing(@PathVariable String isbn){
        return borrowingsService.getBorrowingByIsbn(isbn);
    }
    @GetMapping("/borrowings")
    public List<Borrowings> getBorrowings(){
        return borrowingsService.getBorrowings();
    }

    @PostMapping("/borrowings/s")
    public void addBorrowings(@RequestBody Borrowings borrowings){
        borrowingsService.addBorrowings(borrowings);
    }

    @PostMapping("/borrowings")
    public void addBorrowing(@RequestBody BorrowingsDTO2 borrowingsDTO){
        borrowingsService.addBorrowing(borrowingsDTO);
    }
    @PutMapping("/borrowings")
    public void updateBorrowings(@RequestBody Borrowings borrowings){
        borrowingsService.addBorrowings(borrowings);
    }
    @DeleteMapping("/borrowings/{borrowingId}")
    public void deleteMapping(@PathVariable Long borrowingId){
        borrowingsService.deleteBorrowings(borrowingId);
    }
}
