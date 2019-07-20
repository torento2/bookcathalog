package com.github.torento2.bookcatalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @GetMapping("/book-list")
    public String hello(Model model) {
        return "book-list";
    }
}
