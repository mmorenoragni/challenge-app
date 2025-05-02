package com.example.challenge_app.commons.decorator.impl;

import com.example.challenge_app.commons.ClienteResponse;
import com.example.challenge_app.commons.decorator.IClienteResponseDecorator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class EsperanzaDeVidaDecorator implements IClienteResponseDecorator {

    private final IClienteResponseDecorator clienteDecorator;

    public EsperanzaDeVidaDecorator(IClienteResponseDecorator clienteDecorator) {
        this.clienteDecorator = clienteDecorator;
    }

    @Override
    public void decorate(ClienteResponse cliente) {
        cliente.setEdad((int) ChronoUnit.YEARS.between(cliente.getFechaNacimiento(), LocalDate.now()));
        int coeficienteDeEdad = (new Random().nextInt(10) * cliente.getEdad()) / 10;
        int esperanzaDeVida = Math.round(coeficienteDeEdad + cliente.getEdad());
        cliente.getInformacionExtra().put("esperanzaDeVida", esperanzaDeVida);
        if (clienteDecorator != null) {
            clienteDecorator.decorate(cliente);
        }
    }
}
