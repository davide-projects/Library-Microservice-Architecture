package com.apulia.bookservice.dto;

import jakarta.validation.constraints.Size;

public class BookPatchDTO {

    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    private String title;

    @Size(min = 1, max = 255, message = "Author must be between 1 and 255 characters")
    private String author;

    @Size(min = 1, max = 255, message = "Publisher must be between 1 and 255 characters")
    private String publisher;

    public BookPatchDTO() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
}
