package com.apulia.bookservice.exception;

public class BookNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BookNotFoundException() {
        super("Book not found");
    }

    public BookNotFoundException(Integer id) {
        super("Book with ID " + id + " not found");
    }
}
