package com.github.torento2.bookcatalog.service.impl;

import com.github.torento2.bookcatalog.model.Book;
import com.github.torento2.bookcatalog.repository.BookRepository;
import com.github.torento2.bookcatalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
@Primary
@Service
public class BDBookService implements BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BDBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);

    }
}
