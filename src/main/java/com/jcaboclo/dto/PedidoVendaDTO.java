package com.jcaboclo.dto;

import com.jcaboclo.entity.*;
import java.util.List;

public record PedidoVendaDTO(Long id, Long vendedorId, Long clienteId, List<ItemPedidoDTO> itensPedido) {

    // Método para converter de PedidoVenda para PedidoVendaDTO
    public static PedidoVendaDTO fromEntity(PedidoVenda pedidoVenda) {
        List<ItemPedidoDTO> itens = pedidoVenda.getItensPedido().stream()
                .map(ItemPedidoDTO::fromEntity)
                .toList();
        return new PedidoVendaDTO(pedidoVenda.id,
                pedidoVenda.getVendedor().id,
                pedidoVenda.getCliente().id,
                itens);
    }

    // Método para converter de PedidoVendaDTO para PedidoVenda
    public PedidoVenda toEntity(Vendedor vendedor, Cliente cliente, List<ItemPedido> itensPedido) {
        PedidoVenda pedidoVenda = new PedidoVenda();
        pedidoVenda.id = this.id;
        pedidoVenda.setVendedor(vendedor);
        pedidoVenda.setCliente(cliente);
        pedidoVenda.setItensPedido(itensPedido); // Definindo os itens do pedido
        return pedidoVenda;
    }
}

