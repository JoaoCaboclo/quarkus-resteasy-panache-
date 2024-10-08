package com.jcaboclo;

import com.jcaboclo.service.CreditCardService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class CreditCardServiceTest {

    @Inject
    CreditCardService creditCardService;

    @Test
    public void testValidarCartaoCredito() {
        boolean valid = creditCardService.validarCartaoCredito("555298374487547537642853482638614438231558582693");  // Número fictício de cartão
        assertTrue(!valid);
    }
}

