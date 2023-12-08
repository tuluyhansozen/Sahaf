package com.project.sahafproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sahafproject.entities.Book;
import com.project.sahafproject.entities.Bookstore;
import com.project.sahafproject.exception.BookstoreNotFoundException;
import com.project.sahafproject.repos.BookRepository;
import com.project.sahafproject.repos.BookstoreRepository;

import java.util.List;

@Service
public class BookstoreService {

    @Autowired
    private BookstoreRepository bookstoreRepository;
    
    @Autowired
    private BookRepository bookRepository;


    public List<Bookstore> getAllBookstores() {
        return bookstoreRepository.findAll();
    }

    public Bookstore getBookstore(Long bookstoreId) {
        return bookstoreRepository.findById(bookstoreId)
                .orElseThrow(() -> new BookstoreNotFoundException("Bookstore not found with id: " + bookstoreId));
    }

    public Bookstore saveBookstore(Bookstore bookstore) {
        // You can perform additional validation or business logic here before saving
        return bookstoreRepository.save(bookstore);
    }

    public void deleteBookstore(Long bookstoreId) {
        // Check if the bookstore exists before deleting
        if (bookstoreRepository.existsById(bookstoreId)) {
            bookstoreRepository.deleteById(bookstoreId);
        } else {
            throw new BookstoreNotFoundException("Bookstore not found with id: " + bookstoreId);
        }
    }

    public Bookstore updateBookstore(Long bookstoreId, Bookstore updatedBookstore) {
        // Check if the bookstore exists before updating
        if (bookstoreRepository.existsById(bookstoreId)) {
            Bookstore existingBookstore = bookstoreRepository.findById(bookstoreId).get();
            existingBookstore.setName(updatedBookstore.getName());
            existingBookstore.setLocation(updatedBookstore.getLocation());
            return bookstoreRepository.save(existingBookstore);
            } else {
            throw new BookstoreNotFoundException("Bookstore not found with id: " + bookstoreId);
        }
    }

    public Bookstore createBookstore(String name, String location) {
        Bookstore newBookstore = new Bookstore();
        newBookstore.setName(name);
        newBookstore.setLocation(location);

        return bookstoreRepository.save(newBookstore);
    }
    
    public List<Book> getBooksByBookstore(Long bookstoreId) {
        // Assuming you have a method in BookRepository to find books by bookstore ID
        return bookRepository.findByBookstoreId(bookstoreId);
    }
}

