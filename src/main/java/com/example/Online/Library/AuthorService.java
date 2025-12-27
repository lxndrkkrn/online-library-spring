package com.example.Online.Library;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AuthorService {

    private final Map<Integer, Author> authorStorage = new ConcurrentHashMap<>();

    public void addAuthor(Author author) {

        if (author.id() < 0) return;

        authorStorage.put(author.id(), author);

    }

    public void removeAuthor(Integer id) {

        authorStorage.remove(id);

    }

    public boolean isAuthorExist(Integer id) {

        return authorStorage.containsKey(id);

    }

}
