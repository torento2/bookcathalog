package com.github.torento2.bookcatalog.controller;
import com.github.torento2.bookcatalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;


@Controller
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book-list")
    public String bookList(Model model) {
        model.addAttribute("books" , bookService.getBooks());
        return "book-list";
    }
    @GetMapping("/book-detail/{id}")
    public String bookDetail(Model model, @PathVariable("id") Long id) {
        model.addAttribute("book", bookService.getBook(id));
        return "book-detail";
    }
    @GetMapping("/book-details")
    public String bookDetail1(Model model, @PathParam("id") Long id) {
        return "book-detail";
    }

}
