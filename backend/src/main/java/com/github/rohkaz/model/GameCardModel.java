package com.github.rohkaz.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record GameCardModel(
        int id,
        @JsonAlias("name") String title,
        @JsonAlias("released") String releaseDate,
        List<Genre> genres,
        @JsonAlias("background_image") String cover,
        @JsonAlias("metacritic") int rating
) {
}
