package com.jcaboclo;

import com.jcaboclo.dto.ProdutoDTO;
import com.jcaboclo.entity.Produto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ProdutoTest {

    @Test
    public void testProdutoDtoConversao() {
        // Entidade Produto fictícia
        Produto produto = new Produto();
        produto.id = 1L;
        produto.setNome("Produto Teste");
        produto.setPreco(99.99);

        // Converter para DTO
        ProdutoDTO dto = ProdutoDTO.fromEntity(produto);
        assertEquals(produto.id, dto.id());
        assertEquals(produto.getNome(), dto.nome());
        assertEquals(produto.getPreco(), dto.preco(), 0.01);

        // Converter de volta para entidade
        Produto produtoConvertido = dto.toEntity(null);
        assertEquals(dto.id(), produtoConvertido.id);
        assertEquals(dto.nome(), produtoConvertido.getNome());
        assertEquals(dto.preco(), produtoConvertido.getPreco(), 0.01);
    }
}
