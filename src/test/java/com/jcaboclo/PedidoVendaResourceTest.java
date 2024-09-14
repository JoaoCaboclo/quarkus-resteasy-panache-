package com.jcaboclo;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PedidoVendaResourceTest {

    @Test
    public void testCriarPedido() {
        given()
                .body("{ \"cliente\": { \"id\": 1 }, \"vendedor\": { \"id\": 1 }, \"itens\": [] }")
                .contentType("application/json")
                .when().post("/pedidos")
                .then()
                .statusCode(201);
    }

    @Test
    public void testListarPedidos() {
        RestAssured.given()
                .when().get("/pedidos")
                .then()
                .statusCode(200)
                .body("size()", is(1));
    }
}

