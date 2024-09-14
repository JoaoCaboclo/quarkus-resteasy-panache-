package com.jcaboclo;

import com.jcaboclo.service.CepService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CepServiceTest {

    @Inject
    CepService cepService;

    @Test
    public void testBuscarCep() {
        String cepInfo = cepService.buscarCep("01001000");  // CEP de exemplo
        assertNotNull(cepInfo);
        System.out.println(cepInfo);
    }
}

