package com.github.rohkaz.security;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final AppUserRepository appUserRepository;

    @PostMapping
    public AppUser createNewUser(@RequestBody AppUser user) {
        return appUserRepository.save(user);
    }

    @GetMapping("all")
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

}
