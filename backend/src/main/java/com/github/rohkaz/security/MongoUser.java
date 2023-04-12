package com.github.rohkaz.security;

public record MongoUser(

        String id,
        String username,
        String password,
        String role

) {
}
