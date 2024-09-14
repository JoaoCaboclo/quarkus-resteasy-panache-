package com.jcaboclo.dto;

import com.jcaboclo.entity.ItemPedido;
import com.jcaboclo.entity.PedidoVenda;
import com.jcaboclo.entity.Produto;

public record ItemPedidoDTO(Long produtoId, int quantidade) {

    // Método para converter de ItemPedido para ItemPedidoDTO
    public static ItemPedidoDTO fromEntity(ItemPedido itemPedido) {
        return new ItemPedidoDTO(itemPedido.getProduto().id, itemPedido.getQuantidade());
    }

    // Método para converter de ItemPedidoDTO para ItemPedido
    public ItemPedido toEntity(Produto produto, PedidoVenda pedidoVenda) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setProduto(produto);
        itemPedido.setPedidoVenda(pedidoVenda);
        itemPedido.setQuantidade(this.quantidade);
        return itemPedido;
    }
}

