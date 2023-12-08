package com.project.sahafproject.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookstoreNotFoundException extends RuntimeException {

    public BookstoreNotFoundException(String message) {
        super(message);
    }

    public BookstoreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
