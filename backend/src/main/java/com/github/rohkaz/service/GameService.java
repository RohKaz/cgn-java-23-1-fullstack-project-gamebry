package com.github.rohkaz.service;

import com.github.rohkaz.model.Game;
import com.github.rohkaz.repository.GameRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GameService {

    GameRepo gameRepo;

    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }
}
