package com.pragma.mensajeria.application.handler;

import com.pragma.mensajeria.domain.api.IMessageServicePort;
import com.pragma.mensajeria.domain.model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

class MessageHandlerTest {

    @Mock
    private IMessageServicePort messageServicePort;

    private MessageHandler messageHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        messageHandler = new MessageHandler(messageServicePort);
    }

    @Test
    void sendMessage_shouldSendFormattedMessage() {
        String phone = "+51987654321";
        String code = "123456";
        String expectedBody = "Tu código de verificación es: 123456";

        messageHandler.sendMessage(phone, code);

        verify(messageServicePort).sendMessage(new Message(phone, expectedBody));
    }
}
