package com.project.sahafproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.sahafproject.entities.Book;
import com.project.sahafproject.entities.Bookstore;
import com.project.sahafproject.request.BookstoreDTO;
import com.project.sahafproject.response.BookstoreResponse;
import com.project.sahafproject.service.BookstoreService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookstores")
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    @GetMapping
    public ResponseEntity<List<BookstoreResponse>> getAllBookstores() {
        List<Bookstore> bookstores = bookstoreService.getAllBookstores();
        List<BookstoreResponse> responseList = bookstores.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookstoreResponse> getBookstore(@PathVariable Long id) {
        Bookstore bookstore = bookstoreService.getBookstore(id);
        BookstoreResponse response = convertToResponse(bookstore);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookstoreResponse> createBookstore(@RequestBody BookstoreDTO bookstoreDTO) {
        Bookstore newBookstore = bookstoreService.createBookstore(bookstoreDTO.getName(), bookstoreDTO.getLocation());
        BookstoreResponse response = convertToResponse(newBookstore);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookstore(@PathVariable Long id) {
        bookstoreService.deleteBookstore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookstoreResponse> updateBookstore(@PathVariable Long id, @RequestBody Bookstore updatedBookstore) {
        Bookstore updated = bookstoreService.updateBookstore(id, updatedBookstore);
        BookstoreResponse response = convertToResponse(updated);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksByBookstore(@PathVariable Long id) {
        List<Book> books = bookstoreService.getBooksByBookstore(id);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Helper method to convert Bookstore to BookstoreResponse
    private BookstoreResponse convertToResponse(Bookstore bookstore) {
        return new BookstoreResponse(bookstore.getId(), bookstore.getName(), bookstore.getLocation());
    }

}

