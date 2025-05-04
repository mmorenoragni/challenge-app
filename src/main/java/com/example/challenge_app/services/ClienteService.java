package com.example.challenge_app.services;

import com.example.challenge_app.commons.ClienteResponse;
import com.example.challenge_app.commons.CreateClienteRequest;
import com.example.challenge_app.commons.decorator.IClienteResponseDecorator;
import com.example.challenge_app.commons.decorator.impl.EsperanzaDeVidaDecorator;
import com.example.challenge_app.entities.Cliente;
import com.example.challenge_app.persistence.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponse createCliente(CreateClienteRequest request) {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(request.getNombre());
        nuevoCliente.setApellido(request.getApellido());
        nuevoCliente.setNacimiento(request.getFechaNacimiento());

        final Cliente saved = clienteRepository.save(nuevoCliente);
        ClienteResponse response = new ClienteResponse();
        response.setNombre(saved.getNombre());
        response.setApellido(saved.getApellido());
        response.setFechaNacimiento(saved.getNacimiento());
        response.setEdad((int) ChronoUnit.YEARS.between(saved.getNacimiento(), LocalDate.now()));
        return response;
    }

    public List<ClienteResponse> getAllClientes() {
        List<ClienteResponse> allClients = new ArrayList<>();
        clienteRepository.findAll().forEach(cliente -> allClients.add(mapClienteToResponse(cliente,
                                                                                                  new EsperanzaDeVidaDecorator(null))));
        return allClients;
    }

    private ClienteResponse mapClienteToResponse(Cliente cliente, IClienteResponseDecorator decorator) {
        ClienteResponse response = new ClienteResponse();
        response.setNombre(cliente.getNombre());
        response.setApellido(cliente.getApellido());
        response.setFechaNacimiento(cliente.getNacimiento());
        decorator.decorate(response);
        return response;
    }
}
