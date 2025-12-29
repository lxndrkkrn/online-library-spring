package com.example.Online.Library;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // БД сама будет ставить 1, 2, 3...
    private Integer id;
    private String firstName;
    private String lastName;

    public Author() {}

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

