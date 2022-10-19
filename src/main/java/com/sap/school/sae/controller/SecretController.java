package com.sap.school.sae.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/secret")
public class SecretController {

    @GetMapping
    public ResponseEntity<String> getSecret() {
        return ResponseEntity.of(Optional.of("I am a secret"));
    }

    @GetMapping("/{number}")
    public ResponseEntity<String> getSpecificSecret(@PathVariable("number") int number) {
        return ResponseEntity.of(Optional.of("I am secret Nr." + number));
    }
}
