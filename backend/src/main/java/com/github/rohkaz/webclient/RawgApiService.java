package com.github.rohkaz.webclient;

import com.github.rohkaz.gamecardmodel.GameCardDetailsModel;
import com.github.rohkaz.gamecardmodel.GameCardModel;
import com.github.rohkaz.gamecardmodel.GameCardModelResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class RawgApiService {

    private WebClient webClient;

    public RawgApiService(
            @Value("${rawgapi.url}") String url
    ) {
        this.webClient = WebClient.create(url);
    }

    private static GameCardModel gameCardModel;
    @Value("${rawg.api.key}")
    private String API_KEY;

    /*public List<GameCardModel> getAllGames() {
        GameCardModelResponse allGamesResponse = Objects.requireNonNull(webClient.get()
                        .uri("/games?key=" + API_KEY)
                        .retrieve()
                        .toEntity(GameCardModelResponse.class)
                        .block())
                .getBody();
        return allGamesResponse.results();
    }*/

    public List<GameCardModel> getAllGames() {
        return Objects.requireNonNull(webClient.get()
                .uri("/games?key=" + API_KEY)
                .retrieve()
                .bodyToMono(GameCardModelResponse.class)
                .block()).results();
    }

    public GameCardDetailsModel getGameById(int id) {
        GameCardDetailsModel gameCardModel = Objects.requireNonNull(webClient.get()
                        .uri("/games/" + id + "?key=" + API_KEY)
                        .retrieve()
                        .toEntity(GameCardDetailsModel.class)
                        .block())
                .getBody();
        return gameCardModel;
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
