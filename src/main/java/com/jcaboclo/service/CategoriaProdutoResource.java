package com.jcaboclo.service;

import com.jcaboclo.entity.CategoriaProduto;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaProdutoResource {

    @GET
    public List<CategoriaProduto> listar() {
        return CategoriaProduto.listAll();
    }

    @POST
    @Transactional
    public Response criar(CategoriaProduto categoriaProduto) {
        categoriaProduto.persist();
        return Response.status(Response.Status.CREATED).entity(categoriaProduto).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public CategoriaProduto atualizar(@PathParam("id") Long id, CategoriaProduto categoriaAtualizada) {
        CategoriaProduto categoria = CategoriaProduto.findById(id);
        if (categoria == null) {
            throw new WebApplicationException("Categoria com id " + id + " não existe.", Response.Status.NOT_FOUND);
        }
        categoria.setNome(categoriaAtualizada.getNome());
        categoria.persist();
        return categoria;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        CategoriaProduto categoria = CategoriaProduto.findById(id);
        if (categoria == null) {
            throw new WebApplicationException("Categoria com id " + id + " não existe.", Response.Status.NOT_FOUND);
        }
        categoria.delete();
        return Response.noContent().build();
    }
}
