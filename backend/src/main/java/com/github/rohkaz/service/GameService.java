package com.github.rohkaz.service;

import com.github.rohkaz.gamecardmodel.GameCardModel;
import com.github.rohkaz.repository.GameRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Service
public class GameService {

    private final GameRepo gameRepo;

    public List<GameCardModel> getAllGames() {
        return gameRepo.findAll();
    }

    public GameCardModel getGameByID(String gameId) {
        return gameRepo.findById(gameId).orElseThrow(NoSuchElementException::new);
    }
}
