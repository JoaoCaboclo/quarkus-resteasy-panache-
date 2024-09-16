package com.jcaboclo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class CreditCardService {

    public boolean validarCartaoCredito(String creditCardNumber) {
        String apiUrl = "https://www.vccgenerator.org/br/validador-de-cartao-de-credito/" + creditCardNumber;

        Response response = ClientBuilder.newClient()
                .target(apiUrl)
                .request(MediaType.APPLICATION_JSON)
                .get();

        return response.getStatus() == 200 && response.readEntity(Boolean.class);
    }
}

