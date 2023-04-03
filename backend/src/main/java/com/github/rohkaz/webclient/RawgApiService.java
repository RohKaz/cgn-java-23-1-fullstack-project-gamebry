package com.github.rohkaz.webclient;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Service
public class RawgApiService {

    private WebClient webClient = WebClient.create("https://api.rawg.io/api/");

    public String getNewlyReleasedGames() {
        String newReleasesResponse = Objects.requireNonNull(webClient.get()
                        .uri("/games?key=36c65ecc04c848268be4eb8b44bbce99&dates=2023-01-01,2023-04-04")
                        .retrieve()
                        .toEntity(String.class)
                        .block())
                .getBody();

        return newReleasesResponse;
    }
}
