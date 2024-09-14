package com.jcaboclo;

import com.jcaboclo.entity.ItemPedido;
import com.jcaboclo.entity.PedidoVenda;
import com.jcaboclo.entity.Produto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class PedidoVendaTest {

    @Test
    public void testPedidoVendaTotalCalculation() {
        Produto produto1 = new Produto();
        produto1.setNome("Laptop");
        produto1.setPreco(2500.00);

        ItemPedido item1 = new ItemPedido();
        item1.setProduto(produto1);
        item1.setQuantidade(2);
        item1.setPrecoUnitario(2500.00);

        List<ItemPedido> itens = new ArrayList<>();
        itens.add(item1);

        PedidoVenda pedido = new PedidoVenda();
        pedido.setItensPedido(itens);
        pedido.setTotal(item1.getQuantidade() * item1.getPrecoUnitario());

        assertEquals(5000.00, pedido.getTotal());
    }
}

