package com.github.rohkaz.security;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final AppUserRepository appUserRepository;

    @PostMapping
    public AppUser createNewUser(@RequestBody AppUser user) {
        return appUserRepository.save(user);
    }

}
