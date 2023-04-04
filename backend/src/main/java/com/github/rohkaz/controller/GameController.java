package com.github.rohkaz.controller;

import com.github.rohkaz.model.Game;
import com.github.rohkaz.service.GameService;
import com.github.rohkaz.webclient.RawgApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class GameController {

    private final GameService gameService;
    private final RawgApiService rawgApiService;

    //@GetMapping("/games")
    //public List<Game> getAllGames() {
    //return gameService.getAllGames();
    //}

    @GetMapping("/games/{gameId}")
    public Game getGameByID(@PathVariable String gameId) {
        return gameService.getGameByID(gameId);
    }

    @GetMapping("/games")
    public String getNewlyReleasedGames() {
        return rawgApiService.getNewlyReleasedGames();
    }

    @GetMapping("/games/all")
    public String getAllGames() {
        return rawgApiService.getAllGames();
    }
}



