package com.github.rohkaz.gamecardmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GameCardModel(
        int id,
        @JsonProperty("name") String title,
        @JsonProperty("released") String releaseDate,
        @JsonProperty("background_image") String cover,
        @JsonProperty("metacritic") int rating
) {
}
