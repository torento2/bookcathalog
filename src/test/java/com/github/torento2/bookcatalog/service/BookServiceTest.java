package com.github.torento2.bookcatalog.service;

import com.github.torento2.bookcatalog.model.Book;
import com.github.torento2.bookcatalog.repository.BookRepository;
import com.github.torento2.bookcatalog.service.impl.BDBookService;
import com.github.torento2.bookcatalog.model.Book;
import com.github.torento2.bookcatalog.repository.BookRepository;
import com.github.torento2.bookcatalog.service.impl.BDBookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

// for this test there is no need to run spring context.
// this is only possible because we injected via constructor!!!
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private BDBookService bookService;


    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        bookService = new BDBookService(bookRepository);
    }

    @Transactional
    @Test
    public void bookTest() {
        String title = "title1";
        String isbn = "isbn1";
        String author = "author1";
        String description = "description1";
        Integer year = 9999;
        Book book = new Book(null, title, isbn, author, description, year);

        bookService.addBook(book);
        verify(bookRepository, times(1)).save(book);
    }

}