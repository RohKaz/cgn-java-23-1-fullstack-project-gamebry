package com.github.rohkaz.security;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public AppUser createNewUser(@RequestBody AppUser user) {
        if (user.username() == null || user.username().length() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is required");
        }
        if (user.password() == null || user.password().length() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is required");
        }
        if (appUserRepository.existsByUsername(user.username())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }

        AppUser newUser = new AppUser(
                user.id(),
                user.username(),
                passwordEncoder.encode(user.password()),
                "BASIC"
        );

        AppUser out = appUserRepository.save(newUser);

        return new AppUser(
                out.id(),
                out.username(),
                "********",
                out.role()
        );
    }

    @GetMapping("/all")
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @GetMapping("me")
    public AppUser getLoggedInUser(Principal principal) {
        AppUser me = appUserRepository
                .findByUsername(principal.getName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        return new AppUser(
                me.id(),
                me.username(),
                "********",
                me.role()
        );
    }

    @PostMapping("/login")
    public AppUser login(Principal principal) {
        return getLoggedInUser(principal);
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

}
