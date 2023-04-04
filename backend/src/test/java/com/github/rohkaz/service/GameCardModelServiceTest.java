package com.github.rohkaz.service;

import com.github.rohkaz.gamecardmodel.GameCardModel;
import com.github.rohkaz.repository.GameRepo;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class GameCardModelServiceTest {

    GameService gameService;
    GameRepo gameRepo;
    GameCardModel gameCardModel1;
    GameCardModel gameCardModel2;

    @Nested
    @DisplayName("testing getAllGames")
    class getAllGamesTests {

        @BeforeEach
        public void setup() {
            gameRepo = mock(GameRepo.class);
            gameService = new GameService(gameRepo);
            gameCardModel1 = new GameCardModel("1", "EU4", "An awesome strategy game simulating politics, economics, and warfare", "Paradox", "2013-11-13", List.of("PC"), List.of("Strategy", "Historical"), "https://playidlegames.com/wp-content/uploads/2020/02/91FoEoDOEL._AC_SL1500_.jpg");
            gameCardModel2 = new GameCardModel("2", "TESV", "The best RPG ever made", "Bethesda", "2011-11-11", List.of("PC", "Xbox 360", "Xbox One", "Playstation 3", "Playstation 4", "Nintendo Switch"), List.of("RPG", "Fantasy"), "https://media.indiedb.com/cache/images/members/2/1709/1708407/thumb_620x2000/image.37.jpg");
        }

        @Test
        @DisplayName("should return all games that are saved in the list")
        void getAllGamesIfListIsNotEmpty() {
            //GIVEN
            List<GameCardModel> expected = List.of(gameCardModel1, gameCardModel2);
            when(gameRepo.findAll()).thenReturn(expected);
            //WHEN
            List<GameCardModel> actual = gameService.getAllGames();
            //THEN
            verify(gameRepo).findAll();
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("should return an empty list if no games are saved")
        void getAllGamesIfListIsEmpty() {
            //GIVEN
            List<GameCardModel> expected = List.of();
            when(gameRepo.findAll()).thenReturn(expected);
            //WHEN
            List<GameCardModel> actual = gameService.getAllGames();
            //THEN
            verify(gameRepo).findAll();
            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("testing getGameByID")
    class getGameByIDTestsCardModel {

        @BeforeEach
        public void setup() {
            gameRepo = mock(GameRepo.class);
            gameService = new GameService(gameRepo);
            gameCardModel1 = new GameCardModel("1", "EU4", "An awesome strategy game simulating politics, economics, and warfare", "Paradox", "2013-11-13", List.of("PC"), List.of("Strategy", "Historical"), "\"https://playidlegames.com/wp-content/uploads/2020/02/91FoEoDOEL._AC_SL1500_.jpg\"");
            gameCardModel2 = new GameCardModel("2", "TESV", "The best RPG ever made", "Bethesda", "2011-11-11", List.of("PC", "Xbox 360", "Xbox One", "Playstation 3", "Playstation 4", "Nintendo Switch"), List.of("RPG", "Fantasy"), "\"https://media.indiedb.com/cache/images/members/2/1709/1708407/thumb_620x2000/image.37.jpg\"");
        }

        @Test
        @DisplayName("should return the game with the given id")
        void getGameByIDIfGameIDExists() {
            //GIVEN
            GameCardModel expected = gameCardModel1;
            when(gameRepo.findById("1")).thenReturn(Optional.of(expected));
            //WHEN
            GameCardModel actual = gameService.getGameByID("1");
            //THEN
            verify(gameRepo).findById("1");
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("should throw an exception if no game with the given id exists")
        void getGameByIDIfGameIDDoesNotExist_throwExceptionInstead() {
            //GIVEN
            when(gameRepo.findById("3")).thenReturn(Optional.empty());
            //WHEN
            Assertions.assertThrows(java.util.NoSuchElementException.class, () -> gameService.getGameByID("3"));
            //THEN
            verify(gameRepo).findById("3");
        }
    }
}