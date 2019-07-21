package com.github.torento2.bookcatalog.controller;
import com.github.torento2.bookcatalog.service.BookService;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;


@Controller
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/")
    public String index( ) {
        return "forward:/book-list";
    }
    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute Book book) {
        return "redirect:/book-list";

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
        model.addAttribute("book", bookService.getBook(id));
        return "book-detail";
    }
    @GetMapping("/add-book")
    public String addBook(Model model, @PathParam("id") Long id) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

}
