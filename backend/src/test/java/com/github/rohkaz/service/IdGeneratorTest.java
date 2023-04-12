package com.github.rohkaz.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class IdGeneratorTest {

    @Test
    @DisplayName("should generate a random ID and check if it is not null")
    void generateID() {
        //GIVEN
        IdGenerator idGenerator = new IdGenerator();
        //WHEN
        String id = idGenerator.generateID();
        //THEN
        assertNotNull(id);
    }
}