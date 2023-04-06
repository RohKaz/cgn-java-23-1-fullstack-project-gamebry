package com.github.rohkaz.gamecardmodel;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GameCardDetailsModel(

        int id,
        @JsonAlias("name") String title,
        @JsonProperty("description_raw") String description,
        @JsonAlias("released") String releaseDate,

        List<Publisher> publishers,
        List<Genre> genres,
        @JsonAlias("background_image") String cover,
        @JsonAlias("metacritic") int rating


) {
}
