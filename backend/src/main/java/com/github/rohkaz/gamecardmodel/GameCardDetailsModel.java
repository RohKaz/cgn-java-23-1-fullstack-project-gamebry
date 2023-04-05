package com.github.rohkaz.gamecardmodel;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record GameCardDetailsModel(

        int id,
        @JsonAlias("name") String title,
        String description,
        @JsonAlias("released") String releaseDate,

        List<Publisher> publishers,
        List<Genre> genres,
        @JsonAlias("background_image") String cover,
        @JsonAlias("metacritic") int rating,
        @JsonAlias("platforms") List<Platform> platforms
) {
}
