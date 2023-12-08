package com.project.sahafproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sahafproject.entities.Book;
import com.project.sahafproject.entities.BookRequest;
import com.project.sahafproject.entities.Bookstore;
import com.project.sahafproject.entities.User;
import com.project.sahafproject.exception.BookNotFoundException;
import com.project.sahafproject.exception.BookRequestException;
import com.project.sahafproject.exception.BookRequestNotFoundException;
import com.project.sahafproject.repos.BookRequestRepository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookRequestService {

    @Autowired
    private BookRequestRepository bookRequestRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookstoreService bookstoreService;

    public List<BookRequest> getAllBookRequests() {
        return bookRequestRepository.findAll();
    }

    public BookRequest getBookRequest(Long requestId) {
        return bookRequestRepository.findById(requestId)
                .orElseThrow(() -> new BookRequestNotFoundException("Book request not found with id: " + requestId));
    }

    public BookRequest createBookRequest(Long userId, Long bookId, Long bookstoreId, Date startDate, Date endDate)
            throws BookRequestException, BookNotFoundException {

        User user = userService.getUser(userId);
        Book book = bookService.getBook(bookId);
        Bookstore bookstore = bookstoreService.getBookstore(bookstoreId);
        

        // Check if the book is available for the specified date range
        if (bookRequestRepository.existsByBookAndDateRange(book, startDate, endDate)) {
            throw new BookRequestException("Book is already taken for the specified date range.");
        }

        BookRequest bookRequest = new BookRequest();
        bookRequest.setUser(user);
        bookRequest.setBook(book);
        bookRequest.setBookstore(bookstore);
        bookRequest.setStartDate(startDate);
        bookRequest.setEndDate(endDate);

        return bookRequestRepository.save(bookRequest);
    }

    public void deleteBookRequest(Long requestId) {
        // Check if the book request exists before deleting
        if (bookRequestRepository.existsById(requestId)) {
            bookRequestRepository.deleteById(requestId);
        } else {
            throw new BookRequestNotFoundException("Book request not found with id: " + requestId);
        }
    }


    public Map<Date, Long> getBooksBorrowedPerDay() {
        List<BookRequest> bookRequests = bookRequestRepository.findAll();
        return bookRequests.stream()
                .collect(Collectors.groupingBy(
                        BookRequest::getStartDate,
                        Collectors.counting()
                ));
    }
}
