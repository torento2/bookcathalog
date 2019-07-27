package com.github.torento2.bookcatalog.service;

import com.github.torento2.bookcatalog.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBook(Long id);

    void saveBook(Book book);

    void addBook(Book book);
}
