package com.example.borrowingsservice.service;

import com.example.borrowingsservice.dao.BorrowingsRepository;
import com.example.borrowingsservice.domain.Borrowings;
import com.example.borrowingsservice.service.dto.BookDTO;
import com.example.borrowingsservice.service.dto.BorrowingsDTO;
import com.example.borrowingsservice.service.dto.BorrowingsDTO2;
import com.example.borrowingsservice.service.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingsService implements IBorrowingsService {
    @Autowired
    private BorrowingsRepository borrowingsRepository;
    @Autowired
    CustomerClient customerClient;

    @Autowired
    BookClient bookClient;

    @Override
    public void addBorrowings(Borrowings borrowings) {

        borrowingsRepository.save(borrowings);
    }

    @Override
    public Optional<Borrowings> getBorrowing(Long borrowingId) {
        return borrowingsRepository.findById(borrowingId);
    }


    @Override
    public List<Borrowings> getBorrowings() {
        return borrowingsRepository.findAll();

    }

    @Override
    public void updateBorrowings(Borrowings borrowings) {
        borrowingsRepository.save(borrowings);
    }

    @Override
    public void updateBorrowingsCustomer(CustomerDTO customerDTO) {
        List<Borrowings> borrowingsList = borrowingsRepository.findBorrowingsByCustomerNumber(customerDTO.getCustomerNumber());
        for (Borrowings borrowing : borrowingsList
        ) {
            borrowing.setCustomerName(customerDTO.getName());
            borrowingsRepository.save(borrowing);
        }

    }

    @Override
    public void updateBorrowingsBook(BookDTO bookDTO) {
        Borrowings borrowing = borrowingsRepository.findBorrowingsByIsbn(bookDTO.getIsbn());

        borrowingsRepository.save(borrowing);


    }

    @Override
    public void deleteBorrowings(Long borrowingId) {
        borrowingsRepository.deleteById(borrowingId);
    }


    @Override
    public void addBorrowing(BorrowingsDTO2 borrowingsDTO) {
        CustomerDTO customerDTO = customerClient.getCustomer(borrowingsDTO.getCustomerNumber());
        BookDTO bookDTO = bookClient.getBookDTO(borrowingsDTO.getIsbn());
        Borrowings borrowings = new Borrowings(33L, LocalDate.now(), customerDTO.getCustomerNumber(), customerDTO.getName(), bookDTO.getIsbn(), bookDTO.getTitle());
        borrowingsRepository.save(borrowings);
    }

    @Override
    public Borrowings getBorrowingByIsbn(String isbn) {
        return borrowingsRepository.findBorrowingsByIsbn(isbn);
    }

    @Override
    public void updateBorrowingsfromBook(BookDTO bookDTO) {
        System.out.println(bookDTO.getTitle());
        Borrowings borrowings = borrowingsRepository.findBorrowingsByIsbn(bookDTO.getIsbn());
        Borrowings borrowings1=new Borrowings(borrowings.getBorrowingNumber(),borrowings.getLocalDate(),borrowings.getCustomerNumber(),borrowings.getCustomerName(), borrowings.getIsbn(), bookDTO.getTitle());
        //borrowings.setTitle(bookDTO.getTitle());
        System.out.println(borrowings.getTitle());
        borrowingsRepository.save(borrowings1);

    }
}

@FeignClient(name = "CustomerService")
interface CustomerClient {
    @RequestMapping("/customer/{customerId}")
    CustomerDTO getCustomer(@PathVariable Long customerId);
}

@FeignClient(name = "QueryService")
interface BookClient {
    @RequestMapping("/book/{isbn}")
    BookDTO getBookDTO(@PathVariable String isbn);
}


