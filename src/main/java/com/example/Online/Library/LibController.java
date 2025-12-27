package com.example.Online.Library;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/library")

public class LibController {

    private final AuthorService repositoryAuthor;
    private final BookService repositoryBooks;

    public LibController(AuthorService repositoryAuthor2, BookService repositoryBooks1) {
        this.repositoryAuthor = repositoryAuthor2;
        this.repositoryBooks = repositoryBooks1;
    }

    @PostMapping("/authors") // add author
    public void createAuthor(@RequestBody Author author) {

        repositoryAuthor.addAuthor(author);

    }

    @PostMapping("/books") // add book
    public ResponseEntity<?> createBook(@RequestBody Book book) {

        if (!repositoryAuthor.isAuthorExist(book.authorId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Автора с ID " + book.authorId() + " не найдено. Книга не создана.");
        }

        repositoryBooks.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED).body("Книга успешно создана!");

    }

    @GetMapping("/books") // show all books
    public List<Book> showAllBooks() {

        return repositoryBooks.showAllBooks();

    }

    @GetMapping("/authors/{id}/books")
    public List<Book> showAllBooksByAuthor(@PathVariable Integer id) {

        return repositoryBooks.showAllBooksByAuthorList(id);

    }

    @DeleteMapping("/authors/{id}") // remove author
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {

        if (!repositoryAuthor.isAuthorExist(id)) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Автора с ID: " + id + " не существует.");

        }

        repositoryBooks.removeAllBooks(id);
        repositoryAuthor.removeAuthor(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Автор успешно удалён.");

    }

}