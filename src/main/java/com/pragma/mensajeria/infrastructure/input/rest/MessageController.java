package com.pragma.mensajeria.infrastructure.input.rest;

import com.pragma.mensajeria.application.handler.IMessageHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
@Tag(name = "Message", description = "Gestión de mensajes.")
public class MessageController {

    private final IMessageHandler messageHandler;

    @PostMapping("/send-pin")
    @Operation(
            summary = "Enviar Mensaje",
            security = @SecurityRequirement(name = "bearerAuth"),
            description = "Enviar Mensaje con cuerpo .",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Enviado Correctamente",
                            content = @Content(schema = @Schema(implementation = Void.class))),
                    @ApiResponse(responseCode = "500", description = "Error Interno")
            }
    )
    public ResponseEntity<Void> sendPin(@RequestParam(name = "phoneNumber") String phoneNumber,
                                        @RequestParam(name = "pin") String pin) {
        messageHandler.sendMessage(phoneNumber, pin);
        return ResponseEntity.ok().build();
    }

}
