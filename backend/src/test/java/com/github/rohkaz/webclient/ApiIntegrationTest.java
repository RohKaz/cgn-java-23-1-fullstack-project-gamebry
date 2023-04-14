package com.github.rohkaz.webclient;


import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static MockWebServer mockWebServer;

    @BeforeAll
    static void beforeAll() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @DynamicPropertySource
    static void backendProperties(DynamicPropertyRegistry registry) {
        registry.add("rawgapi.url", () -> mockWebServer.url("/").toString());
    }

    @Test
    @WithMockUser(username = "Roh", password = "password")
    void testGetAllGames() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .setHeader("Content-Type", "application/json")
                .setBody("""
                        {
                        "results": [
                        {
                        "id": 1,
                        "name": "test",
                        "released": "2021-01-01",
                        "genres": [{"name": "test"}],
                        "background_image": "test",
                        "rating": 1,
                        "platforms": [{"name": "test"}]
                        }
                        ]
                        }
                        """));

        mockMvc.perform(get("/api/games"))
                .andExpect(status().isOk());
    }

    @AfterAll
    static void afterAll() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    @WithMockUser(username = "Roh", password = "password", roles = "BASIC")
    void testGetNewAndUpcomingGames() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .setHeader("Content-Type", "application/json")
                .setBody("""
                        {
                        "results": [
                        {
                        "id": 1,
                        "name": "test",
                        "released": "2021-01-01",
                        "genres": [{"name": "test"}],
                        "background_image": "test",
                        "rating": 1,
                        "platforms": [{"name": "test"}]
                        }
                        ]
                        }
                        """));

        mockMvc.perform(get("/api/games/new"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "Roh", password = "password", roles = "BASIC")
    void testGetGameById() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .setHeader("Content-Type", "application/json")
                .setBody("""
                        {
                        "id": 1,
                        "name": "test",
                        "released": "2021-01-01",
                        "genres": [{"name": "test"}],
                        "background_image": "test",
                        "rating": 1,
                        "platforms": [{"name": "test"}]
                        }
                        """));

        mockMvc.perform(get("/api/games/1"))
                .andExpect(status().isOk());
    }

}
