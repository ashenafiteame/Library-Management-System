package com.example.clientapplication.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookList {
    private List<BookQuery> bookQueryList;

    public BookList() {
        this.bookQueryList = new ArrayList<>();
    }
}
