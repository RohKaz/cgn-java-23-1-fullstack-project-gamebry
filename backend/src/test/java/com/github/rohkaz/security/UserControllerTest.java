package com.github.rohkaz.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    AppUserRepository appUserRepository;

    @Test
    @DirtiesContext
    @DisplayName("should return status 200 and name of user")
    @WithMockUser(username = "Roh", password = "password", roles = "BASIC")
    void whenGetLoggedInUser_ThenReturnStatus200AndNameOfUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/me"))
                .andExpect(status().isOk())
                .andExpect(content().string("Roh"));
    }

    @Nested
    @DisplayName("testing createNewUser - api/users")
    class UserCreationTests {
        @Test
        @DirtiesContext
        void whenCreateNewUser_thenReturnNewUserWithStatus200OK() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                            .content("""
                                    {
                                    "id": "1",
                                    "username": "Roh",
                                    "password": "password",
                                    "role": "BASIC"
                                    }
                                    """)
                            .contentType("application/json"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("""
                            {
                            "id": "1",
                            "username": "Roh",
                            "password": "********",
                            "role": "BASIC"
                            }
                            """));
        }

        @Test
        @DirtiesContext
        @DisplayName("should return status 400 and Username is required")
        void whenCreateNewUserWithNoUsername_ThenReturnStatus400() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                            .content("""
                                    {
                                    "id": "1",
                                    "password": "password",
                                    "role": "BASIC"
                                    }
                                    """)
                            .contentType("application/json"))
                    .andExpect(status().isBadRequest());
        }

        @Test
        @DirtiesContext
        @DisplayName("should return status 400 and Password is required")
        void whenCreateNewUserWithNoPassword_ThenReturnStatus400() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                            .content("""
                                    {
                                    "id": "1",
                                    "username": "Roh",
                                    "role": "BASIC"
                                    }
                                    """)
                            .contentType("application/json"))
                    .andExpect(status().isBadRequest());
        }

        @Test
        @DirtiesContext
        @DisplayName("should return status 409 and User already exists")
        void whenCreateNewUserThatAlreadyExists_ThenReturnStatus409() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                            .content("""
                                    {
                                    "id": "2",
                                    "username": "Phillip",
                                    "password": "password",
                                    "role": "BASIC"
                                    }
                                    """)
                            .contentType("application/json"))
                    .andExpect(status().isOk());
            mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                            .content("""
                                    {
                                    "id": "2",
                                    "username": "Phillip",
                                    "password": "password",
                                    "role": "BASIC"
                                    }
                                    """)
                            .contentType("application/json"))
                    .andExpect(status().isConflict());
        }
    }

    @Nested
    @DisplayName("testing getAllUsers - api/users/all")
    class getUsersTests {
        @Test
        @DirtiesContext
        @DisplayName("should give out the list of all users that are saved in the database")
        @WithMockUser(username = "Roh", password = "password", roles = "BASIC")
        void whenGetAllUsers_thenReturnListWith200OK() throws Exception {
            appUserRepository.save(new AppUser("1", "Roh", "password", "BASIC"));
            appUserRepository.save(new AppUser("2", "Phillip", "password", "BASIC"));
            mockMvc.perform(MockMvcRequestBuilders.get("/api/users/all"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("""
                            [
                            {
                            "id": "1",
                            "username": "Roh",
                            "password": "password",
                            "role": "BASIC"
                            },
                            {
                            "id": "2",
                            "username": "Phillip",
                            "password": "password",
                            "role": "BASIC"
                            }
                            ]
                                                    
                            """));
        }
    }

}
