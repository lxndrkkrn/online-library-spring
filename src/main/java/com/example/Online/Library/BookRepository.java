package com.example.Online.Library;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAuthorId(Integer authorId);

    @Modifying
    @Transactional
    void deleteByAuthorId(Integer authorId);

}
