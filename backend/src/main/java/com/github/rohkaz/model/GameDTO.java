package com.github.rohkaz.model;

import java.util.List;

public record GameDTO(
        String gameTitle,
        String gameDescription,
        String gameDeveloper,
        String gameReleaseDate,
        List<String> gamePlatforms,
        List<String> gameGenres,
        String gameCover
) {
}
