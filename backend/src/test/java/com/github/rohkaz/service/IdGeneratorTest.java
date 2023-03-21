package com.github.rohkaz.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class IdGeneratorTest {
    IdGenerator idGenerator = new IdGenerator();

    @Test
    void generateID() {
        assertNotNull(idGenerator.generateID());
    }
}