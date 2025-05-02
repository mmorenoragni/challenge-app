package com.example.challenge_app.services;

import com.example.challenge_app.commons.ClienteResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricsService {

    public Integer calculateAverageAge(List<ClienteResponse> allClientes) {
        int total = 0;
        for (ClienteResponse client: allClientes) {
            total += client.getEdad();
        }
        return total / allClientes.size();
    }

    public Integer calculateStandardDeviation(List<ClienteResponse> allClientes) {
        int sd;
        double dif;
        double sumDif = 0;
        int average = this.calculateAverageAge(allClientes);

        for (ClienteResponse client: allClientes) {
            dif = Math.pow(average - client.getEdad(),2);
            sumDif += dif;
        }
        sd = (int) Math.sqrt(sumDif/allClientes.size());
        return sd;
    }
}
