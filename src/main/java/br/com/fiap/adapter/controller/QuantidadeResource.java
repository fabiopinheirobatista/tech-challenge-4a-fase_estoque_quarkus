package br.com.fiap.adapter.controller;

import br.com.fiap.core.domain.Produto;
import br.com.fiap.core.usecase.estoque.ListarQuantidadesUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/estoque")
public class QuantidadeResource {

    @Inject
    ListarQuantidadesUseCase listarQuantidadesUseCase;

    @GET
    @Path("/quantidades")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarQuantidades() {
        List<Produto> produtos = listarQuantidadesUseCase.executar();
        return Response.ok(produtos).build();
    }

}
