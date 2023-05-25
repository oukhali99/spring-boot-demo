package com.example.demo.entities.book;

import com.example.demo.entities.book.exception.BookAlreadyRentedException;
import com.example.demo.entities.user.User;
import com.example.demo.entities.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void rentBook(Long bookId, String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        System.out.println(user.getUsername());

        Book book = bookRepository.getReferenceById(bookId);

        // Check if the book is already rented
        if (book.isRented()) {
            throw new BookAlreadyRentedException(bookId);
        }

        book.setRenter(user);
    }

}
