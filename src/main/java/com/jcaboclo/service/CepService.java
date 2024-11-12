package com.jcaboclo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class CepService {

    public String buscarCep(String cep) {

        String apiUrl = "https://viacep.com.br/ws/" + cep + "/json/";

        Response response = ClientBuilder.newClient()
                .target(apiUrl)
                .request(MediaType.APPLICATION_JSON)
                .get();

        if (response.getStatus() == 200) {
            return response.readEntity(String.class);  // Retorna o JSON da API
        } else {
            throw new RuntimeException("Erro ao buscar CEP: " + response.getStatus());
        }
    }
}

