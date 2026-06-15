package com.apulia.bookservice.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("Book not found");
    }

    public BookNotFoundException(Integer id) {
        super("Book with ID " + id + " not found");
    }
}
