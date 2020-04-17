package com.matan.users.controllers;

import brave.ScopedSpan;
import brave.Tracer;
import com.matan.users.messagings.MessagesBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping()
public class UsersController {

    private final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Value("${matan.value: default}")
    private String name;

    private final MessagesBinding messagesBinding;
    private final Tracer tracer;
    private MessageChannel greetChannel;

    public UsersController(MessagesBinding messagesBinding, Tracer tracer) {
        this.messagesBinding = messagesBinding;
        this.tracer = tracer;
    }

    @PostConstruct
    public void initMessaging() {
        greetChannel = messagesBinding.greeting();
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkConfig() {
        tracer.currentSpan().tag("user", "matan");
        ScopedSpan span = tracer.startScopedSpan("customSpan");
        try {
            span.tag("property", "value-matan");
        } catch (Exception e) {
            logger.error(e.toString());
        } finally {
            span.finish();
        }
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
