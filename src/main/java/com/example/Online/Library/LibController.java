package com.example.Online.Library;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/library")

public class LibController {

    private final AuthorService authorService;
    private final BookService bookService;

    public LibController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostMapping("/authors") // add author
    public void createAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
    }

    @PostMapping("/books") // add book
    public ResponseEntity<?> createBook(@RequestBody Book book) {

        try {

            bookService.saveBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body("Книга успешно создана!");

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/books") // show all books
    public List<Book> showAllBooks() {

        return bookService.findAllBooks();

    }

    @GetMapping("/authors/{id}/books") // show all books by authorID
    public List<Book> showAllBooksByAuthor(@PathVariable Integer id) {
        return bookService.showAllBooksByAuthor(id);
    }

    @DeleteMapping("/authors/{id}") // remove author
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {

        if (authorService.deleteAuthor(id)) {

            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Автор успешно удалён.");

        } else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Автора с ID: " + id + " не существует.");}

    }

}