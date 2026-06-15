package com.apulia.bookservice.exception;

public class SearchException extends RuntimeException {

    public SearchException() {
        super("Search error");
    }

    public SearchException(String message) {
        super(message);
    }
}
