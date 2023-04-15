package com.github.rohkaz.security;

public record AppUser(

        String id,
        String username,
        String password,
        String role

) {
}
