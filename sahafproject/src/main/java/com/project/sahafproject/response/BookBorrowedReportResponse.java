package com.project.sahafproject.response;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class BookBorrowedReportResponse {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date date;
    private Long booksBorrowed;

    // Default constructor
    public BookBorrowedReportResponse() {
    }

    // Parameterized constructor
    public BookBorrowedReportResponse(Date date, Long booksBorrowed) {
        this.date = date;
        this.booksBorrowed = booksBorrowed;
    }

    // Getters and setters
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(Long booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }
}
