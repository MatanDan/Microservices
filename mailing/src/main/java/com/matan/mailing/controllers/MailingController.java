package com.matan.mailing.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping()
public class MailingController {

    private final Logger logger = LoggerFactory.getLogger(MailingController.class);

    private final RestTemplate restTemplate;

    public MailingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("check")
    public ResponseEntity<String> check() {
        logger.info("I send a HTTP req to users microservice using services discovery");
        return restTemplate.getForEntity("http://users/check", String.class);
    }

}
