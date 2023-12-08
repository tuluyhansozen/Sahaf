package com.project.sahafproject.response;

import com.project.sahafproject.entities.Bookstore;

public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private Bookstore bookstore;

    // Constructors, Getters, and Setters

    public BookResponse(Long id, String title, String author, Bookstore bookstore) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.bookstore = bookstore;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public Bookstore getBookstore() {
        return bookstore;
    }

    public void setBookstore(Bookstore bookstore) {
        this.bookstore = bookstore;
    }
}

