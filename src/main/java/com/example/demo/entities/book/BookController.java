package com.example.demo.entities.book;

import com.example.demo.config.response.ResponseContent;
import com.example.demo.config.response.ResponseContentSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = { "/api/v1/book", "/api/v1/book/" })
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseContent home() {
        return new ResponseContentSuccess(bookService.getBooks());
    }

    @PostMapping
    public ResponseContent addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseContentSuccess("Successfully added book " + book.getName());
    }

    @PostMapping(path = "/rent")
    public ResponseContent rentBook(@RequestParam Long id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        bookService.rentBook(id, username);

        return new ResponseContentSuccess("Successfully rented book " + id);
    }

}
