package com.jcaboclo.service;

import com.jcaboclo.dto.PedidoVendaDTO;
import com.jcaboclo.entity.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.transaction.Transactional;
import java.util.List;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoVendaResource {

    @GET
    public Response listarPedidos() {
        return Response.ok(PedidoVenda.<PedidoVenda>listAll().stream()
                .map(PedidoVendaDTO::fromEntity)
                .toList()).build();
    }

    @POST
    @Transactional
    public Response criarPedido(PedidoVendaDTO dto) {
        // Obtenha o Vendedor e o Cliente
        Vendedor vendedor = Vendedor.findById(dto.vendedorId());
        Cliente cliente = Cliente.findById(dto.clienteId());

        // Crie a instância de PedidoVenda
        PedidoVenda pedidoVenda = new PedidoVenda();
        pedidoVenda.setVendedor(vendedor);
        pedidoVenda.setCliente(cliente);

        // Agora converta os itens do pedido, passando PedidoVenda como argumento
        List<ItemPedido> itensPedido = dto.itensPedido().stream()
                .map(itemDto -> {
                    Produto produto = Produto.findById(itemDto.produtoId());
                    return itemDto.toEntity(produto, pedidoVenda);  // Agora passando produto e pedidoVenda
                })
                .toList();

        // Associe os itens ao pedido
        pedidoVenda.setItensPedido(itensPedido);

        // Persista o pedido
        pedidoVenda.persist();

        // Retorne a resposta com o PedidoVendaDTO criado
        return Response.status(Response.Status.CREATED).entity(PedidoVendaDTO.fromEntity(pedidoVenda)).build();
    }



}

