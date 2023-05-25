package com.example.demo.entities.book.exception;

import com.example.demo.exception.ApiException;

public class BookAlreadyRentedException extends ApiException {
    public BookAlreadyRentedException(Long bookId) {
        super("Book with id " + bookId + " is already rented");
    }
}
