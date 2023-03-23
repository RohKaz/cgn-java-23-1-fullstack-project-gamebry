package com.github.rohkaz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("game")
public record Game(
        @Id
        String gameId,
        String gameTitle,
        String gameDescription

) {
}
