package com.example.Online.Library;

import org.springframework.stereotype.Service;

public record Book(Integer id, String title, Integer authorId, Integer year) {
}