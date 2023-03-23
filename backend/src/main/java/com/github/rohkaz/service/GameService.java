package com.github.rohkaz.service;

import com.github.rohkaz.model.Game;
import com.github.rohkaz.repository.GameRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class GameService {

    private final GameRepo gameRepo;

    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }
}
