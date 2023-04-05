package com.github.rohkaz.gamecardmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GameCardModel(
        int id,
        @JsonProperty("name") String title,
        @JsonProperty("released") String releaseDate,
        List<Genre> genres,
        @JsonProperty("background_image") String cover,
        @JsonProperty("metacritic") int rating
) {
}
