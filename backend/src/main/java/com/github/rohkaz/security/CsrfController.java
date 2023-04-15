package com.github.rohkaz.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/csrf")
public class CsrfController {

    @GetMapping()
    public String getCsrfToken() {
        return "CSRF OK";
    }
}
