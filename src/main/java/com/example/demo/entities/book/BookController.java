package com.example.demo.entities.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = { "/api/v1/book", "/api/v1/book/" })
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> home() {
        return bookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

}
