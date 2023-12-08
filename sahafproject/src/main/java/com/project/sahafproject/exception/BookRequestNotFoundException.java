package com.project.sahafproject.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookRequestNotFoundException extends RuntimeException {

    public BookRequestNotFoundException(String message) {
        super(message);
    }

    public BookRequestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
