package com.pragma.mensajeria.domain.usecase;

import com.pragma.mensajeria.domain.model.Message;
import com.pragma.mensajeria.domain.spi.IMessagePersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.*;

class MessageUseCaseTest {

    @Mock
    private IMessagePersistencePort messagePersistencePort;

    private MessageUseCase messageUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        messageUseCase = new MessageUseCase(messagePersistencePort);
    }

    @Test
    void sendMessage_shouldDelegateToPersistencePort() {
        Message message = new Message("+51987654321", "Mensaje de prueba");

        messageUseCase.sendMessage(message);

        verify(messagePersistencePort).sendMessage(message);
    }
}
