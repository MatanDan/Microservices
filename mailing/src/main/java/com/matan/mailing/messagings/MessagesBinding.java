package com.matan.mailing.messagings;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessagesBinding {

    String GREETINGS_CHANNEL = "greetingChannel";

    @Input(GREETINGS_CHANNEL)
    SubscribableChannel greeting();
}
