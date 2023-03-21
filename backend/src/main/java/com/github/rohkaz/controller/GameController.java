package com.github.rohkaz.controller;

import com.github.rohkaz.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

}
