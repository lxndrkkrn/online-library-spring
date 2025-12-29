package com.example.Online.Library;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final AuthorRepository repositoryAuthor;
    private final BookRepository repositoryBooks;

    public BookService(AuthorRepository repositoryAuthor, BookRepository repositoryBook) {
        this.repositoryAuthor = repositoryAuthor;
        this.repositoryBooks = repositoryBook;
    }

    public void saveBook(Book book) {

        if (!repositoryAuthor.existsById(book.getAuthorId())) {
            throw new RuntimeException("Author not found");
        }
        if (book.getReleaseYear() < 0) {
            throw new RuntimeException("Invalid year");
        }

        repositoryBooks.save(book);

    }

    public List<Book> findAllBooks() {

        return repositoryBooks.findAll();

    }

    public List<Book> showAllBooksByAuthor(Integer id) {

        return repositoryBooks.findByAuthorId(id);

    }

}
