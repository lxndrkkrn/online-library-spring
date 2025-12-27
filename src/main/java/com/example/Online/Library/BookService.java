package com.example.Online.Library;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookService {

    private final Map<Integer, Book> bookStorage = new ConcurrentHashMap<>();

    public void addBook(Book book) {

        if (book.id() < 0) return;

        bookStorage.put(book.id(), book);

    }

    public void removeAllBooks(Integer authorId) {

        bookStorage.values().removeIf(book -> book.authorId().equals(authorId));

    }

    public List<Book> showAllBooks() {

        return new ArrayList<>(bookStorage.values());

    }

    public List<Book> showAllBooksByAuthorList(Integer authorId) {

        return bookStorage.values().stream().filter(book -> book.authorId().equals(authorId)).toList();

    }

}
