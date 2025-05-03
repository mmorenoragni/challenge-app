package com.example.challenge_app.controllers;

import com.example.challenge_app.commons.ClienteResponse;
import com.example.challenge_app.commons.CreateClienteRequest;
import com.example.challenge_app.commons.WrapperResponse;
import com.example.challenge_app.dto.Metricas;
import com.example.challenge_app.events.EmailSenderEventPublisher;
import com.example.challenge_app.services.ClienteService;
import com.example.challenge_app.services.MetricsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "ClienteController", description = "Este controller provee funciones para interactuar con la entidad cliente")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final MetricsService metricsService;
    private final EmailSenderEventPublisher emailSenderEventPublisher;

    public ClienteController(ClienteService clienteService,
                             MetricsService metricsService,
                             EmailSenderEventPublisher emailSenderEventPublisher) {
        this.clienteService = clienteService;
        this.metricsService = metricsService;
        this.emailSenderEventPublisher = emailSenderEventPublisher;
    }

    @Operation(summary = "Api para la creacion de un nuevo cliente", security = @SecurityRequirement(name = "basicAuth"))
    @PostMapping()
    public ResponseEntity<WrapperResponse<ClienteResponse>> create(@Valid @RequestBody CreateClienteRequest request) {
        WrapperResponse<ClienteResponse> response = new WrapperResponse();
        ClienteResponse clienteResponse = clienteService.createCliente(request);
        response.setApiResponse(clienteResponse);
        emailSenderEventPublisher.publishEmailSenderEvent("creation of user %s".formatted(clienteResponse.toString()));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Api para obtener todos los clientes", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping( "/get-all")
    public ResponseEntity<WrapperResponse<List<ClienteResponse>>> getAll() {
        WrapperResponse<List<ClienteResponse>> response = new WrapperResponse();
        response.setApiResponse(clienteService.getAllClientes());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/metricas")
    public ResponseEntity<WrapperResponse<Metricas>> getMetricas() throws JsonProcessingException {
        WrapperResponse<Metricas> response = new WrapperResponse();
        List<ClienteResponse> clientes = clienteService.getAllClientes();
        Metricas metricas = new Metricas(metricsService.calculateAverageAge(clientes),
                metricsService.calculateStandardDeviation(clientes));
        response.setApiResponse(metricas);
        return ResponseEntity.ok(response);
    }
}
