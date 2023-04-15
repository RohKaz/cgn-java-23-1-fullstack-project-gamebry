package com.github.rohkaz.webclient;

import com.github.rohkaz.model.GameCardDetailsModel;
import com.github.rohkaz.model.GameCardModel;
import com.github.rohkaz.model.GameCardModelResponse;
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

    @Value("${rawg.api.key}")
    private String API_KEY;

    public List<GameCardModel> getAllGames() {
        return Objects.requireNonNull(webClient.get()
                .uri("/games?key=" + API_KEY)
                .retrieve()
                .bodyToMono(GameCardModelResponse.class)
                .block()).results();
    }

    public GameCardDetailsModel getGameById(int id) {
        return Objects.requireNonNull(webClient.get()
                .uri("/games/" + id + "?key=" + API_KEY)
                .retrieve()
                .bodyToMono(GameCardDetailsModel.class)
                .block());
    }

    public List<GameCardModel> getNewAndUpcomingGames() {
        return Objects.requireNonNull(webClient.get()
                .uri("/games?key=" + API_KEY + "&dates=2023-01-01,2024-01-01")
                .retrieve()
                .bodyToMono(GameCardModelResponse.class)
                .block()).results();
    }
}