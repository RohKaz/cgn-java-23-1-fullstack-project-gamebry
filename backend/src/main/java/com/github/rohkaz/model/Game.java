package com.github.rohkaz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("game")
public record Game(
        @Id
        String gameId,
        String gameTitle,
        String gameDescription,
        String gameDeveloper,
        String gameReleaseDate,
        List<String> gamePlatforms,
        List<String> gameGenres,
        String gameCover

) {
}
