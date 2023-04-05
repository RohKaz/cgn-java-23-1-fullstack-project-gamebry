package com.github.rohkaz.gamecardmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GameCardDetailsModel(

        int id,
        @JsonProperty("name") String title,
        String description,
        @JsonProperty("released") String releaseDate,
        @JsonProperty("background_image") String cover,
        @JsonProperty("metacritic") int rating
) {
}
