package com.github.rohkaz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("game")
public record Game(
        @Id
        String id,
        String title,
        String description,
        String publisher,
        String releaseDate,
        List<String> platforms,
        List<String> genres,
        String cover
) {
}
