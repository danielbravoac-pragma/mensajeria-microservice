package com.pragma.mensajeria.infrastructure.input.rest;

import com.pragma.mensajeria.application.handler.IMessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageController {

    private final IMessageHandler messageHandler;

    @PostMapping("/send-pin")
    public ResponseEntity<Void> sendPin(@RequestParam(name = "phoneNumber") String phoneNumber,
                                        @RequestParam(name = "pin") String pin) {
        messageHandler.sendMessage(phoneNumber, pin);
        return ResponseEntity.ok().build();
    }

}
