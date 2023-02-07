package com.example.clientapplication.dto;

public class AdapterClass {
    public static BookDTO toDTO(BookQuery bookQuery){
        return  new BookDTO(bookQuery.getIsbn(), bookQuery.getTitle(), bookQuery.getDescription(), bookQuery.getAuthorName());
    }
    public static BookQuery fromDTO(BookDTO bookDTO){
        return new BookQuery(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getDescription(), bookDTO.getAuthorName(),null);
    }
}
