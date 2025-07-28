package br.com.fiap.adapter.controller;

import br.com.fiap.core.domain.Produto;
import br.com.fiap.core.usecase.estoque.AjustarEstoqueUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/estoque")
public class EstoqueResource {

    @Inject
    AjustarEstoqueUseCase ajustarEstoqueUseCase;

    @PUT
    @Path("/{id}/ajustar")
    public Response ajustarEstoque(@PathParam("id") Long id, @QueryParam("quantidade") int quantidade) {
        Produto produto = ajustarEstoqueUseCase.executar(id, quantidade);
        return Response.ok(produto).build();
    }
}