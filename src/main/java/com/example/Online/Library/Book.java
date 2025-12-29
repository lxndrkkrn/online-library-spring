package com.example.Online.Library;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private Integer authorId;
    private Integer releaseYear; // Поле переименовано

    public Book() {}

    public Book(String title, Integer releaseYear, Integer authorId) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.authorId = authorId;
    }

    // 3. Правильные геттеры и сеттеры (соответствуют именам полей)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}
