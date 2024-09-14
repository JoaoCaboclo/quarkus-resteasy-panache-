package com.jcaboclo.service;

import com.jcaboclo.entity.Vendedor;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/vendedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendedorResource {

    @GET
    public List<Vendedor> listar() {
        return Vendedor.listAll();
    }

    @POST
    @Transactional
    public Response criar(Vendedor vendedor) {
        vendedor.persist();
        return Response.status(Response.Status.CREATED).entity(vendedor).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Vendedor atualizar(@PathParam("id") Long id, Vendedor vendedorAtualizado) {
        Vendedor vendedor = Vendedor.findById(id);
        if (vendedor == null) {
            throw new WebApplicationException("Vendedor com id " + id + " não existe.", Response.Status.NOT_FOUND);
        }
        vendedor.setNome(vendedorAtualizado.getNome());
        vendedor.persist();
        return vendedor;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        Vendedor vendedor = Vendedor.findById(id);
        if (vendedor == null) {
            throw new WebApplicationException("Vendedor com id " + id + " não existe.", Response.Status.NOT_FOUND);
        }
        vendedor.delete();
        return Response.noContent().build();
    }
}

