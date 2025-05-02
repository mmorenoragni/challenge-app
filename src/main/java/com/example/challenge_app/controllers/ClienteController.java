package com.example.challenge_app.controllers;

import com.example.challenge_app.commons.ClienteResponse;
import com.example.challenge_app.commons.CreateClienteRequest;
import com.example.challenge_app.commons.WrapperResponse;
import com.example.challenge_app.services.ClienteService;
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

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Api para la creacion de un nuevo cliente", security = @SecurityRequirement(name = "basicAuth"))
    @PostMapping()
    public ResponseEntity<WrapperResponse<ClienteResponse>> create(@Valid @RequestBody CreateClienteRequest request) {
        WrapperResponse<ClienteResponse> response = new WrapperResponse();
        response.setApiResponse(clienteService.createCliente(request));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Api para obtener todos los clientes", security = @SecurityRequirement(name = "basicAuth"))
    @GetMapping(value = "/get-all")
    public ResponseEntity<WrapperResponse<List<ClienteResponse>>> getAll() {
        WrapperResponse<List<ClienteResponse>> response = new WrapperResponse();
        response.setApiResponse(clienteService.getAllClientes());
        return ResponseEntity.ok(response);
    }
}
