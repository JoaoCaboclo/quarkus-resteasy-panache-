package com.jcaboclo.service;

import com.jcaboclo.dto.CategoriaProdutoDTO;
import com.jcaboclo.entity.CategoriaProduto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaProdutoResource {

    EntityManagerFactory entityManagerFactory;

    @GET
    public List<CategoriaProduto> listar() {
        return CategoriaProduto.listAll();
    }

    @PersistenceContext
    private EntityManager em;

    @POST
    @Transactional
    public Response criar(CategoriaProdutoDTO categoriaProdutoDTO) {
        CategoriaProduto categoriaProduto = categoriaProdutoDTO.toEntity();
        CategoriaProduto.persist(categoriaProduto);
        return Response.status(Response.Status.CREATED).entity(categoriaProdutoDTO).build();
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
