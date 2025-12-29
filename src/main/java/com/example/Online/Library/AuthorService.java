package com.example.Online.Library;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository repositoryAuthor;
    private final BookRepository repositoryBooks;

    public AuthorService(AuthorRepository repositoryAuthor, BookRepository repositoryBooks) {
        this.repositoryAuthor = repositoryAuthor;
        this.repositoryBooks = repositoryBooks;
    }

    public void saveAuthor(Author author) {
        repositoryAuthor.save(author);
    }

    public boolean deleteAuthor(Integer id) {

        if (!repositoryAuthor.existsById(id)) {
            return false;
        }

        deleteAuthorNotLogic(id);
        return true;
    }

    @Transactional
    public void deleteAuthorNotLogic(Integer id) {
        repositoryBooks.deleteByAuthorId(id);
        repositoryAuthor.deleteById(id);
    }

}
