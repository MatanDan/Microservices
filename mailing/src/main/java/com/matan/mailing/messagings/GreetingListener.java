package com.matan.mailing.messagings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MessagesBinding.class)
public class GreetingListener {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @StreamListener(target = MessagesBinding.GREETINGS_CHANNEL)
    public void processHelloChannelGreeting(String msg) {
        log.info("Listening for: " + msg);
    }

}
