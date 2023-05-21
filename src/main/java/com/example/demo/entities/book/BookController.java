package com.example.demo.entities.book;

import com.example.demo.config.response.ApiResponse;
import com.example.demo.config.response.ApiResponseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = { "/api/v1/book", "/api/v1/book/" })
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ApiResponse home() {
        return new ApiResponseSuccess(bookService.getBooks());
    }

    @PostMapping
    public ApiResponse addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ApiResponseSuccess("Successfully added book " + book.getName());
    }

    @PostMapping(path = "/rent")
    public ApiResponse rentBook(@RequestParam Long id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        bookService.rentBook(id, username);

        return new ApiResponseSuccess("Successfully rented book " + id);
    }

}
