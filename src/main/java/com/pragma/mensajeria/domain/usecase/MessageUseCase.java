package com.pragma.mensajeria.domain.usecase;

import com.pragma.mensajeria.domain.api.IMessageServicePort;
import com.pragma.mensajeria.domain.model.Message;
import com.pragma.mensajeria.domain.spi.IMessagePersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageUseCase implements IMessageServicePort {

    private final IMessagePersistencePort messagePersistencePort;

    @Override
    public void sendMessage(Message message) {
        messagePersistencePort.sendMessage(message);
    }
}
