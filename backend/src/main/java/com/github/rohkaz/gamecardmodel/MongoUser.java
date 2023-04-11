package com.github.rohkaz.gamecardmodel;

public record MongoUser(

        String id,
        String username,
        String password,
        String role

) {
}
