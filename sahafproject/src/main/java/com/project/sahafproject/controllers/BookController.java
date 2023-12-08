package com.project.sahafproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.sahafproject.entities.Book;
import com.project.sahafproject.request.BookDTO;
import com.project.sahafproject.response.BookResponse;
import com.project.sahafproject.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<BookResponse> responseList = books.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id) {
        Book book = bookService.getBook(id);
        BookResponse response = convertToResponse(book);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookDTO bookDTO) {
        Book newBook = bookService.createBook(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getBookstoreId());
        BookResponse response = convertToResponse(newBook);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO, Book updatedBook) {
        Book book = bookService.updateBook(id, bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getBookstoreId(), updatedBook);
        BookResponse response = convertToResponse(book);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Helper method to convert Book to BookResponse
    private BookResponse convertToResponse(Book book) {
        return new BookResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getBookstore());
    }

}

