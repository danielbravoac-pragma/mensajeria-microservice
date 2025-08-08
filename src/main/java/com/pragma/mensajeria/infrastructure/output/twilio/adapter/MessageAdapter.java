package com.pragma.mensajeria.infrastructure.output.twilio.adapter;

import com.pragma.mensajeria.domain.model.Message;
import com.pragma.mensajeria.domain.spi.IMessagePersistencePort;
import com.pragma.mensajeria.infrastructure.configuration.TwilioProperties;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageAdapter implements IMessagePersistencePort {

    private final TwilioProperties twilioProperties;

    @Override
    public void sendMessage(Message message) {
        com.twilio.rest.api.v2010.account.Message.creator(
                new PhoneNumber(message.getPhoneNumber()),
                new PhoneNumber(twilioProperties.getFromNumber()),
                message.getMessageBody()
        ).create();
    }
}
