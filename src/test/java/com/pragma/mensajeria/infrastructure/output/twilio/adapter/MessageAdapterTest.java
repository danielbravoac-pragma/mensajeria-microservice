package com.pragma.mensajeria.infrastructure.output.twilio.adapter;

import com.pragma.mensajeria.domain.model.Message;
import com.pragma.mensajeria.infrastructure.configuration.TwilioProperties;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MessageAdapterTest {

    private MessageAdapter messageAdapter;
    private TwilioProperties twilioProperties;

    @BeforeEach
    void setUp() {
        twilioProperties = new TwilioProperties();
        twilioProperties.setFromNumber("+14155238886");
        messageAdapter = new MessageAdapter(twilioProperties);
    }

    @Test
    void sendMessage_shouldCallTwilioMessageCreator() {
        Message message = new Message("+51987654321", "Mensaje de prueba");

        try (MockedStatic<com.twilio.rest.api.v2010.account.Message> mocked = mockStatic(com.twilio.rest.api.v2010.account.Message.class)) {
            MessageCreator creatorMock = mock(MessageCreator.class);
            mocked.when(() ->
                    com.twilio.rest.api.v2010.account.Message.creator(
                            new PhoneNumber(message.getPhoneNumber()),
                            new PhoneNumber(twilioProperties.getFromNumber()),
                            message.getMessageBody()
                    )
            ).thenReturn(creatorMock);

            when(creatorMock.create()).thenReturn(null); // no nos interesa el retorno real

            messageAdapter.sendMessage(message);

            mocked.verify(() ->
                    com.twilio.rest.api.v2010.account.Message.creator(
                            new PhoneNumber(message.getPhoneNumber()),
                            new PhoneNumber(twilioProperties.getFromNumber()),
                            message.getMessageBody()
                    )
            );
            verify(creatorMock).create();
        }
    }
}
