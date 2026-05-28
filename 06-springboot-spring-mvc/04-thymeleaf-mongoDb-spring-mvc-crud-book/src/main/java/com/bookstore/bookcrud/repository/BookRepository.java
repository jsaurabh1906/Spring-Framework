package com.bookstore.bookcrud.repository;


import com.bookstore.bookcrud.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}