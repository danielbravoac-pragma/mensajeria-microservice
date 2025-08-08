package com.pragma.mensajeria.domain.api;

import com.pragma.mensajeria.domain.model.Message;

public interface IMessageServicePort {
    void sendMessage(Message message);
}
