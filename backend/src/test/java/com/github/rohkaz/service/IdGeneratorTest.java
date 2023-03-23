package com.github.rohkaz.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class IdGeneratorTest {

    @Test
    void checkIfIDwasCreated() {
        //GIVEN
        IdGenerator idGenerator = new IdGenerator();
        //WHEN
        String id = idGenerator.generateID();
        //THEN
        assertNotNull(id);
    }
}