package com.github.torento2.bookcatalog.controller;

import com.github.torento2.bookcatalog.model.Book;
import com.github.torento2.bookcatalog.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;

    @Test
    public void index() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().is2xxSuccessful())
                .andExpect(view().name("forward:/book-list"))
                .andExpect(forwardedUrl("/book-list"));

    }

    @Test
    public void saveBook() {
    }

    @Test
    public void bookList() {
    }

    @Test
    public void bookDetail() throws Exception {
        Long id = 99L;
        String author= "author1";
        String title= "title";
        String isbn="isbn1";
        String description="description1";
        Integer year=9999;
        Book book= new Book(id,author, title,isbn,description,year);
        when(bookService.getBook(id)).thenReturn(book);
        mockMvc.perform(get("/book-detail/" + id))
                .andExpect(status().isOk());

    }

    @Test
    public void bookDetail1() {
    }

    @Test
    public void addBook() {
    }
}