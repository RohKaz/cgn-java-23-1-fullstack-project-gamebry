package com.github.rohkaz.gamecardmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GameCardModel(
        @JsonProperty("id") String id,
        @JsonProperty("name") String title,
        @JsonProperty("released") String releaseDate,
        @JsonProperty("background_image") String cover,
        @JsonProperty("metacritic") String rating
) {
}
