package com.project.sahafproject.request;

import java.util.Date;

public class BookRequestDTO {

    private Long userId;
    private Long bookId;
    private Long bookstoreId;
    private Date startDate;
    private Date endDate;

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookstoreId() {
        return bookstoreId;
    }

    public void setBookstoreId(Long bookstoreId) {
        this.bookstoreId = bookstoreId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

