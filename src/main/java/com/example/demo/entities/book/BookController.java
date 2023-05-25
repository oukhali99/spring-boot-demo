package com.example.demo.entities.book;

import com.example.demo.config.response.ResponseContent;
import com.example.demo.config.response.ResponseContentSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = { "/api/v1/book", "/api/v1/book/" })
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<ResponseContent> home() {
        return ResponseEntity.ok(new ResponseContentSuccess(bookService.getBooks()));
    }

    @PostMapping
    public ResponseEntity<ResponseContent> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok(new ResponseContentSuccess("Successfully added book " + book.getName()));
    }

    @PostMapping(path = "/rent")
    public ResponseEntity<ResponseContent> rentBook(@RequestParam Long id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        bookService.rentBook(id, username);

        return ResponseEntity.ok(new ResponseContentSuccess("Successfully rented book " + id));
    }

}
