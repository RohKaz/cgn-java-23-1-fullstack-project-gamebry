package com.github.rohkaz.security;

public record User(

        String id,
        String username,
        String password,
        String role

) {
}
