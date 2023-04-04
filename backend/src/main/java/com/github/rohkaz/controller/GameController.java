package com.github.rohkaz.controller;

import com.github.rohkaz.webclient.RawgApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class GameController {
    private final RawgApiService rawgApiService;

    @GetMapping("/games")
    public String getNewlyReleasedGames() {
        return rawgApiService.getNewlyReleasedGames();
    }

    @GetMapping("/games/all")
    public String getAllGames() {
        return rawgApiService.getAllGames();
    }
}



