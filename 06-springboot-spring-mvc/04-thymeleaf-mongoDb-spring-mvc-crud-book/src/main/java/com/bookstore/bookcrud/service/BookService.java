package com.bookstore.bookcrud.service;

import com.bookstore.bookcrud.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
}
