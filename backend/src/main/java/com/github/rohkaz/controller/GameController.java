package com.github.rohkaz.controller;

import com.github.rohkaz.gamecardmodel.GameCardDetailsModel;
import com.github.rohkaz.model.GameDTO;
import com.github.rohkaz.gamecardmodel.GameCardModel;
import com.github.rohkaz.webclient.RawgApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class GameController {
    private final RawgApiService rawgApiService;

    @GetMapping("/games/new")
    public List<GameCardModel> getNewAndUpcomingGames() {
        return rawgApiService.getNewAndUpcomingGames();
    }

    @GetMapping("/games")
    public List<GameCardModel> getAllGames() {
        return rawgApiService.getAllGames();
    }

    @GetMapping("/games/{id}")
    public GameCardDetailsModel getGameById(@PathVariable int id) {
        return rawgApiService.getGameById(id);
    }

    @PostMapping("/favorites")
    public Game addGame(@RequestBody GameDTO game) {
        return gameService.addGame(game);
    }


}
