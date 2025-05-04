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
        int esperanzaDeVida = Math.round(coeficienteDeEdad(cliente.getEdad()) + cliente.getEdad());
        cliente.getInformacionExtra().put("esperanzaDeVida", esperanzaDeVida);
        if (clienteDecorator != null) {
            clienteDecorator.decorate(cliente);
        }
    }

    private long coeficienteDeEdad(int edadActual) {
        if (edadActual > 0 && edadActual <= 20) {
            return Math.round(2.7 * edadActual);
        }

        if (edadActual > 20 && edadActual <= 30) {
            return Math.round(2.5 * edadActual);
        }

        if (edadActual > 30 && edadActual <= 50) {
            return Math.round(1.5 * edadActual);
        }
        if (edadActual > 60) {
            return Math.round(0.5 * edadActual);
        }

        return 0;
    }
}
