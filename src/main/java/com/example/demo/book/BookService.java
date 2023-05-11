package com.example.demo.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public void addBook(Book book) {
        System.out.println("Adding " + book);
    }

    public List<Book> getBooks() {
        return List.of();
    }

}
