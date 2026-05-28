package com.bookstore.bookcrud.service;

import com.bookstore.bookcrud.model.Book;
import com.bookstore.bookcrud.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
