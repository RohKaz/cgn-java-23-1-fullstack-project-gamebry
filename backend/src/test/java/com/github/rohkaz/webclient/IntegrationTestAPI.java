package com.github.rohkaz.webclient;


import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestAPI {

    @Autowired
    MockMvc mockMvc;

    private static MockWebServer mockWebServer;

    @Test
    public void testGetAllGames() throws Exception {
        mockMvc.perform(get("/api/games"))
                .andExpect(status().isOk());
    }

}
