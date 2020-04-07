package com.matan.mailing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping()
public class MailingController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("check")
    public ResponseEntity<String> check() {
        return restTemplate.getForEntity("http://users/check", String.class);
    }

}
