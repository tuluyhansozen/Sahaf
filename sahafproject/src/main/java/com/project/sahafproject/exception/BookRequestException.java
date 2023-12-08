package com.project.sahafproject.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookRequestException extends RuntimeException {

    public BookRequestException(String message) {
        super(message);
    }
}
