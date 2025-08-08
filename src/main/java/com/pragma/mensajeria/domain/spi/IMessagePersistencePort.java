package com.pragma.mensajeria.domain.spi;

import com.pragma.mensajeria.domain.model.Message;

public interface IMessagePersistencePort {
    void sendMessage(Message message);
}
