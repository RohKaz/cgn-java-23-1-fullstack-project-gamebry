package com.github.rohkaz.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GameCardDetailsModel(

        @JsonProperty("description_raw") String description,
        int id,
        @JsonAlias("name") String title,
        @JsonAlias("released") String releaseDate,
        List<Publisher> publishers,
        List<Genre> genres,
        @JsonAlias("background_image") String cover,
        @JsonAlias("metacritic") int rating


) {
}
