package com.github.rohkaz.webclient;

import com.github.rohkaz.gamecardmodel.GameCardModel;
import com.github.rohkaz.gamecardmodel.GameCardModelResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class RawgApiService {

    private WebClient webClient = WebClient.create("https://api.rawg.io/api/");
    private static GameCardModel gameCardModel;
    private static final String API_KEY = "36c65ecc04c848268be4eb8b44bbce99";

    public List<GameCardModel> getAllGames() {
        GameCardModelResponse allGamesResponse = Objects.requireNonNull(webClient.get()
                        .uri("/games?key=" + API_KEY)
                        .retrieve()
                        .toEntity(GameCardModelResponse.class)
                        .block())
                .getBody();
        return allGamesResponse.results();
    }
    public List<GameCardModel> getNewAndUpcomingGames() {
        GameCardModelResponse newAndUpcomingGamesResponse = Objects.requireNonNull(webClient.get()
                        .uri("/games?key=" + API_KEY + "&dates=2023-01-01,2024-01-01")
                        .retrieve()
                        .toEntity(GameCardModelResponse.class)
                        .block())
                .getBody();

        return newAndUpcomingGamesResponse.results();
    }
}
