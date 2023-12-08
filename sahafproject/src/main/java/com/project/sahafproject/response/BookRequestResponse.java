package com.project.sahafproject.response;


public class BookRequestResponse {

    private Long id;
    private Long userId;
    private Long bookId;
    private Long bookstoreId;
    private String startDate;
    private String endDate;

    // Constructors, Getters, and Setters

    public BookRequestResponse(Long id, Long userId, Long bookId, Long bookstoreId, String startDate, String endDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.bookstoreId = bookstoreId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

