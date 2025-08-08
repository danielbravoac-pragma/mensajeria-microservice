package com.pragma.mensajeria.application.handler;

import com.pragma.mensajeria.domain.api.IMessageServicePort;
import com.pragma.mensajeria.domain.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageHandler implements IMessageHandler {

    private final IMessageServicePort messageServicePort;

    @Override
    public void sendMessage(String phoneNumber, String body) {
        messageServicePort.sendMessage(new Message(phoneNumber, "Tu código de verificación es: " + body));
    }
}
