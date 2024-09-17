package com.jcaboclo.service;

import com.jcaboclo.dto.CategoriaProdutoDTO;
import com.jcaboclo.dto.ProdutoDTO;
import com.jcaboclo.entity.CategoriaProduto;
import com.jcaboclo.entity.Produto;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> listar() {
        return Produto.listAll();
    }

    @GET
    @Path("{id}")
    public Produto buscarPorId(@PathParam("id") Long id) {
        return Produto.findById(id);
    }

    @POST
    @Transactional
    public Response criar(ProdutoDTO produtoDTO) {
        CategoriaProduto categoriaProduto = new CategoriaProduto();
        Produto produto = produtoDTO.toEntity(categoriaProduto);
        Produto.persist(produto);
        return Response.status(Response.Status.CREATED).entity(produtoDTO).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Produto atualizar(@PathParam("id") Long id, Produto produtoAtualizado) {
        Produto produto = Produto.findById(id);
        if (produto == null) {
            throw new WebApplicationException("Produto com id " + id + " não existe.", Response.Status.NOT_FOUND);
        }
        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.persist();
        return produto;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deletar(@PathParam("id") Long id) {
        Produto produto = Produto.findById(id);
        if (produto == null) {
            throw new WebApplicationException("Produto com id " + id + " não existe.", Response.Status.NOT_FOUND);
        }
        produto.delete();
        return Response.noContent().build();
    }
}

