package com.github.torento2.bookcatalog.integration;

import com.github.torento2.bookcatalog.model.Book;
import com.github.torento2.bookcatalog.service.BookService;
import com.github.torento2.bookcatalog.model.Book;
import com.github.torento2.bookcatalog.service.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIT {

    @Autowired
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void bookDetailTest() throws Exception {

        Book book;

        String title = "title1";
        String isbn = "isbn1";
        String author = "author1";
        String description = "description1";
        Integer year = 9999;
        book = new Book(null, title, isbn, author, description, year);
        bookService.addBook(book);

        //notice id was filled in the book object
        mockMvc.perform(get("/book-detail/" + book.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("book-detail"))
                .andExpect(model().attributeExists("book"))
                .andExpect(model().attribute("book", hasProperty("id", is(book.getId()))))
                .andExpect(model().attribute("book", hasProperty("title", is(book.getTitle()))))
                .andExpect(model().attribute("book", hasProperty("isbn", is(book.getIsbn()))))
                .andExpect(model().attribute("book", hasProperty("author", is(book.getAuthor()))))
                .andExpect(model().attribute("book", hasProperty("description", is(book.getDescription()))))
                .andExpect(model().attribute("book", hasProperty("year", is(book.getYear()))));
    }

}
