package com.project.sahafproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.sahafproject.entities.BookRequest;
import com.project.sahafproject.request.BookRequestDTO;
import com.project.sahafproject.response.BookBorrowedReportResponse;
import com.project.sahafproject.response.BookRequestResponse;
import com.project.sahafproject.service.BookRequestService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/book-requests")
public class BookRequestController {

    @Autowired
    private BookRequestService bookRequestService;

    @GetMapping
    public ResponseEntity<List<BookRequestResponse>> getAllBookRequests() {
        List<BookRequest> bookRequests = bookRequestService.getAllBookRequests();
        List<BookRequestResponse> responseList = bookRequests.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookRequestResponse> getBookRequest(@PathVariable Long id) {
        BookRequest bookRequest = bookRequestService.getBookRequest(id);
        BookRequestResponse response = convertToResponse(bookRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookRequestResponse> createBookRequest(@RequestBody BookRequestDTO requestDTO) {
        BookRequest bookRequest = bookRequestService.createBookRequest(
                requestDTO.getUserId(), requestDTO.getBookId(), requestDTO.getBookstoreId(), requestDTO.getStartDate(), requestDTO.getEndDate()
        );
        BookRequestResponse response = convertToResponse(bookRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookRequest(@PathVariable Long id) {
        bookRequestService.deleteBookRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/report/books-borrowed-per-day")
    public ResponseEntity<List<BookBorrowedReportResponse>> getBooksBorrowedPerDayReport() {
        Map<Date, Long> reportData = bookRequestService.getBooksBorrowedPerDay();

        List<BookBorrowedReportResponse> reportResponseList = reportData.entrySet().stream()
                .map(entry -> new BookBorrowedReportResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(reportResponseList, HttpStatus.OK);
    }
    
    // Helper method to convert BookRequest to BookRequestResponse
    private BookRequestResponse convertToResponse(BookRequest bookRequest) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return new BookRequestResponse(
                bookRequest.getId(),
                bookRequest.getUser().getId(),
                bookRequest.getBook().getId(),
                bookRequest.getBookstore().getId(),
                dateFormat.format(bookRequest.getStartDate()),
                dateFormat.format(bookRequest.getEndDate())
        );
    }
    


}

