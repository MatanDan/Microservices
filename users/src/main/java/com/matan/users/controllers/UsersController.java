package com.matan.users.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class UsersController {

    @Value("${matan.value: default}")
    private String name;

    @GetMapping("/check")
    public ResponseEntity<String> checkConfig() {
        return ResponseEntity.ok(name);
    }
}
