package com.pragma.mensajeria.application.handler;

public interface IMessageHandler {
    void sendMessage(String phoneNumber, String body);
}
