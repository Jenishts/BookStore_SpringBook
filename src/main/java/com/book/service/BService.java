package com.book.service;

import com.book.model.Book;

import java.util.List;

public interface BService {
    Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> listBook();
}
