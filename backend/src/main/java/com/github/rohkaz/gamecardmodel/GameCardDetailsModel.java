package com.github.rohkaz.gamecardmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GameCardDetailsModel(

        int id,
        @JsonProperty("name") String title,
        String description,
        @JsonProperty("released") String releaseDate,

        List<Publisher> publishers,
        List<Genre> genres,
        @JsonProperty("background_image") String cover,
        @JsonProperty("metacritic") int rating
) {
}
