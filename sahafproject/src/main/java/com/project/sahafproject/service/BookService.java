package com.project.sahafproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sahafproject.entities.Book;
import com.project.sahafproject.entities.Bookstore;
import com.project.sahafproject.exception.BookNotFoundException;
import com.project.sahafproject.repos.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private BookstoreService bookstoreService;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + bookId));
    }

    public Book saveBook(Book book) {
        // You can perform additional validation or business logic here before saving
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        // Check if the book exists before deleting
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
        } else {
            throw new BookNotFoundException("Book not found with id: " + bookId);
        }
    }
    
    public Book createBook(String title, String author, Long bookstoreId) {
        Book book = new Book();
        
        // Check if bookstoreId is not null before proceeding
        if (bookstoreId != null) {
            Bookstore bookstore = bookstoreService.getBookstore(bookstoreId);
            book.setAuthor(author);
            book.setTitle(title);
            book.setBookstore(bookstore);
            return bookRepository.save(book);
        } else {
            // Handle the case where bookstoreId is null, for example, by throwing an exception or returning null.
            throw new IllegalArgumentException("Bookstore ID cannot be null");
        }
    }

    
    public Book updateBook(Long bookId, String title, String author, Long bookstoreId, Book updatedBook) {
        // Check if the book exists before updating
        if (bookRepository.existsById(bookId)) {
            // Set the ID of the updated book to the existing book's ID
            updatedBook.setId(bookId);
            updatedBook.setTitle(title);
            updatedBook.setAuthor(author);
            Bookstore bookstore = bookstoreService.getBookstore(bookstoreId);
            updatedBook.setBookstore(bookstore);
            return bookRepository.save(updatedBook);
        } else {
            throw new BookNotFoundException("Book not found with id: " + bookId);
        }
    }

    // Add other methods as needed
}
