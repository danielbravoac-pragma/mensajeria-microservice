package com.pragma.mensajeria.infrastructure.configuration;

import com.pragma.mensajeria.domain.api.IMessageServicePort;
import com.pragma.mensajeria.domain.spi.IMessagePersistencePort;
import com.pragma.mensajeria.domain.usecase.MessageUseCase;
import com.pragma.mensajeria.infrastructure.output.twilio.adapter.MessageAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final TwilioProperties twilioProperties;

    @Bean
    public IMessagePersistencePort messagePersistencePort() {
        return new MessageAdapter(twilioProperties);
    }

    @Bean
    public IMessageServicePort messageServicePort() {
        return new MessageUseCase(messagePersistencePort());
    }

}
