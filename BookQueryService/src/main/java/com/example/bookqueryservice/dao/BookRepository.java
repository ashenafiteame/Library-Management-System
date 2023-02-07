package com.example.bookqueryservice.dao;

import com.example.bookqueryservice.domain.BookQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookQuery,String> {

}
