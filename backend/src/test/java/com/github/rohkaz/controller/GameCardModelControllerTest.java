package com.github.rohkaz.controller;

import com.github.rohkaz.gamecardmodel.GameCardModel;
import com.github.rohkaz.repository.GameRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GameCardModelControllerTest {

    @Autowired
    GameRepo gameRepo;
    @Autowired
    MockMvc mockMvc;

    GameCardModel gameCardModel1, gameCardModel2;

    @BeforeEach
    void setup() {
        gameCardModel1 = new GameCardModel("1", "EU4", "An awesome strategy game simulating politics, economics, and warfare", "Paradox", "2013-11-13", List.of("PC"), List.of("Strategy", "Historical"), "https://playidlegames.com/wp-content/uploads/2020/02/91FoEoDOEL._AC_SL1500_.jpg");
        gameCardModel2 = new GameCardModel("2", "TESV", "The best RPG ever made", "Bethesda", "2011-11-11", List.of("PC", "Xbox 360", "Xbox One", "Playstation 3", "Playstation 4", "Nintendo Switch"), List.of("RPG", "Fantasy"), "https://media.indiedb.com/cache/images/members/2/1709/1708407/thumb_620x2000/image.37.jpg");
    }

    @Nested
    @DisplayName("testing getAllGames - api/games")
    class testGetAllGames {
        @Test
        @DirtiesContext
        @DisplayName("should return all games that are saved in the list")
        void whenGetAllGamesAndListIsNotEmpty_thenReturnListWith200OK() throws Exception {
            gameRepo.save(gameCardModel1);
            gameRepo.save(gameCardModel2);
            mockMvc.perform(MockMvcRequestBuilders.get("/api/games"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("""
                            [
                                {
                                    "gameId": "1",
                                    "gameTitle": "EU4",
                                    "gameDescription": "An awesome strategy game simulating politics, economics, and warfare",
                                    "gameDeveloper": "Paradox",
                                    "gameReleaseDate": "2013-11-13",
                                    "gamePlatforms": ["PC"],
                                    "gameGenres": ["Strategy", "Historical"],
                                    "gameCover": "https://playidlegames.com/wp-content/uploads/2020/02/91FoEoDOEL._AC_SL1500_.jpg"
                                },
                                {
                                    "gameId": "2",
                                    "gameTitle": "TESV",
                                    "gameDescription": "The best RPG ever made",
                                    "gameDeveloper": "Bethesda",
                                    "gameReleaseDate": "2011-11-11",
                                    "gamePlatforms": ["PC", "Xbox 360", "Xbox One", "Playstation 3", "Playstation 4", "Nintendo Switch"],
                                    "gameGenres": ["RPG", "Fantasy"],
                                    "gameCover": "https://media.indiedb.com/cache/images/members/2/1709/1708407/thumb_620x2000/image.37.jpg"
                                }
                            ]
                            """));
        }

        @Test
        @DirtiesContext
        @DisplayName("should return an empty list if no games are saved")
        void whenGetAllGamesAndListIsEmpty_thenReturnEmptyListWith200OK() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/games"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("[]"));

        }
    }

    @Nested
    @DisplayName("testing getGameByID - api/games/{id}")
    class testGetGameByIDCardModel {
        @Test
        @DirtiesContext
        @DisplayName("should return the game with the given id")
        void whenGetGameByIDAndGameExists_thenReturnGameWith200OK() throws Exception {
            gameRepo.save(gameCardModel1);
            gameRepo.save(gameCardModel2);
            mockMvc.perform(MockMvcRequestBuilders.get("/api/games/" + gameCardModel1.gameId()))
                    .andExpect(status().isOk())
                    .andExpect(content().json("""
                            {
                                "gameId": "1",
                                "gameTitle": "EU4",
                                "gameDescription": "An awesome strategy game simulating politics, economics, and warfare",
                                "gameDeveloper": "Paradox",
                                "gameReleaseDate": "2013-11-13",
                                "gamePlatforms": ["PC"],
                                "gameGenres": ["Strategy", "Historical"],
                                "gameCover": "https://playidlegames.com/wp-content/uploads/2020/02/91FoEoDOEL._AC_SL1500_.jpg"
                            }
                            """));
        }
    }
}