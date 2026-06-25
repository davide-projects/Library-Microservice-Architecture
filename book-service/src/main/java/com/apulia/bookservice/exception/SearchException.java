package com.apulia.bookservice.exception;

public class SearchException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SearchException() {
        super("Search error");
    }

    public SearchException(String message) {
        super(message);
    }
}
