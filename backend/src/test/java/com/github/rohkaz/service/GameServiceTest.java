package com.github.rohkaz.service;

import com.github.rohkaz.model.Game;
import com.github.rohkaz.repository.GameRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class GameServiceTest {

    GameService gameService;
    GameRepo gameRepo;
    Game game1;
    Game game2;

    @Nested
    @DisplayName("testing getAllGames")
    class getAllGamesTests {

        @BeforeEach
        public void setup() {
            gameRepo = mock(GameRepo.class);
            gameService = new GameService(gameRepo);
            game1 = new Game("1", "EU4", "An awesome strategy game simulating politics, economics, and warfare");
            game2 = new Game("2", "TESV", "The best RPG ever made");
        }

        @Test
        @DisplayName("should return all games that are saved in the list")
        void getAllGamesIfListIsNotEmpty() {
            //GIVEN
            List<Game> expected = List.of(game1, game2);
            when(gameRepo.findAll()).thenReturn(expected);
            //WHEN
            List<Game> actual = gameService.getAllGames();
            //THEN
            verify(gameRepo).findAll();
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("should return an empty list if no games are saved")
        void getAllGamesIfListIsEmpty() {
            //GIVEN
            List<Game> expected = List.of();
            when(gameRepo.findAll()).thenReturn(expected);
            //WHEN
            List<Game> actual = gameService.getAllGames();
            //THEN
            verify(gameRepo).findAll();
            assertEquals(expected, actual);
        }
    }
}