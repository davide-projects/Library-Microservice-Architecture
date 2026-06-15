package com.apulia.bookservice.service;

import com.apulia.bookservice.exception.BookNotFoundException;
import com.apulia.bookservice.exception.SearchException;
import com.apulia.bookservice.model.Book;
import com.apulia.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book getBookById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Transactional
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book updateBook(int id, Book book) {
        Book existingBook = getBookById(id);

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublisher(book.getPublisher());

        return bookRepository.save(existingBook);
    }

    @Transactional
    public Book patchBook(int id, Map<String, Object> updates) {

        Book existingBook = getBookById(id);

        updates.forEach((key, value) -> {

            if (value == null) {
                throw new SearchException("Field '" + key + "' cannot be null");
            }

            String stringValue = value.toString().trim();

            switch (key) {
                case "title" -> {
                    if (stringValue.isBlank()) {
                        throw new SearchException("Title cannot be empty");
                    }
                    existingBook.setTitle(stringValue);
                }
                case "author" -> {
                    if (stringValue.isBlank()) {
                        throw new SearchException("Author cannot be empty");
                    }
                    existingBook.setAuthor(stringValue);
                }
                case "publisher" -> {
                    if (stringValue.isBlank()) {
                        throw new SearchException("Publisher cannot be empty");
                    }
                    existingBook.setPublisher(stringValue);
                }
                default -> throw new SearchException("Field '" + key + "' is not supported");
            }
        });

        return bookRepository.save(existingBook);
    }

    @Transactional
    public void deleteBook(int id) {
        Book existingBook = getBookById(id);
        bookRepository.delete(existingBook);
    }

    @Transactional(readOnly = true)
    public List<Book> searchByAuthorAndTitle(String author, String title) {

        boolean hasAuthor = (author != null && !author.isBlank());
        boolean hasTitle  = (title != null && !title.isBlank());

        if (!hasAuthor && !hasTitle) {
            throw new SearchException("You must specify at least 'author' or 'title'");
        }

        List<Book> results;

        if (hasAuthor && !hasTitle) {
            results = bookRepository.findByAuthorContainingIgnoreCase(author);
        }
        else if (!hasAuthor) {
            results = bookRepository.findByTitleContainingIgnoreCase(title);
        }
        else {
            results = bookRepository
                    .findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCase(author, title);
        }

        if (results.isEmpty()) {
            throw new SearchException("No books found with the provided criteria");
        }

        return results;
    }
}
