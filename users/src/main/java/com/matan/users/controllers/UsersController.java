package com.matan.users.controllers;

import com.matan.users.messagings.MessagesBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping()
public class UsersController {

    @Value("${matan.value: default}")
    private String name;

    @Autowired
    private MessagesBinding messagesBinding;

    private MessageChannel greetChannel;

    @PostConstruct
    public void initMessaging() {
        greetChannel = messagesBinding.greeting();
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkConfig() {
        return ResponseEntity.ok(name);
    }

    @GetMapping("/sendToMailing")
    public ResponseEntity<String> sendToMailing() {
        Message<String> msg = MessageBuilder.withPayload("Hello, " + name + "!")
                .build();
        greetChannel.send(msg);
        return ResponseEntity.ok("Done!");
    }

}
