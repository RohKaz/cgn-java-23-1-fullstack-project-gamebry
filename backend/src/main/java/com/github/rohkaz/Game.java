package com.github.rohkaz;

import java.util.List;

public record Game(

        String gameId,
        String gameTitle,
        String gamePublisher,
        List<String> gameGenres,
        String gameReleaseDate,
        List<String> gamePlatforms,
        String gameDescription


) {
}
