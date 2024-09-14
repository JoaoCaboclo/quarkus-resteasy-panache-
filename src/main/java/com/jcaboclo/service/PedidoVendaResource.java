package com.jcaboclo.service;

import com.jcaboclo.entity.PedidoVenda;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoVendaResource {

    @Inject
    CreditCardService creditCardService;

    @Inject
    CepService cepService;

    @POST
    @Transactional
    public Response criar(PedidoVenda pedido) {

        // Buscar o CEP do cliente via API externa
        String cepInfo = cepService.buscarCep(pedido.getCliente().getCep());
        System.out.println("CEP Info: " + cepInfo);

        // Validar o cartão de crédito
        boolean cartaoValido = creditCardService.validarCartaoCredito(pedido.getCliente().getCreditCardNumber());
        if (!cartaoValido) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Cartão de crédito inválido").build();
        }

        // Calcular o total do pedido com base nos itens
        double total = pedido.getItens().stream()
                .mapToDouble(item -> item.getPrecoUnitario() * item.getQuantidade())
                .sum();
        pedido.setTotal(total);

        pedido.persist();
        return Response.status(Response.Status.CREATED).entity(pedido).build();
    }

    @GET
    public List<PedidoVenda> listar() {
        return PedidoVenda.listAll();
    }

    @GET
    @Path("{id}")
    public PedidoVenda buscarPorId(@PathParam("id") Long id) {
        return PedidoVenda.findById(id);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        PedidoVenda pedido = PedidoVenda.findById(id);
        if (pedido == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        pedido.delete();
        return Response.noContent().build();
    }
}
