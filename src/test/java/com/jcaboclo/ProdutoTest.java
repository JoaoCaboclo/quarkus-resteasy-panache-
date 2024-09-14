package com.jcaboclo;

import com.jcaboclo.entity.Produto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ProdutoTest {

    @Test
    public void testProdutoAttributes() {
        Produto produto = new Produto();
        produto.setNome("Laptop");
        produto.setPreco(2500.00);

        assertEquals("Laptop", produto.getNome());
        assertEquals(2500.00, produto.getPreco());
    }
}
