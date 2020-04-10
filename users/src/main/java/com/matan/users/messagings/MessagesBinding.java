package com.matan.users.messagings;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessagesBinding {

    @Output("greetingChannel")
    MessageChannel greeting();

}
