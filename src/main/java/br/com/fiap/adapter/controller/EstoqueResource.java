package br.com.fiap.adapter.controller;

import br.com.fiap.adapter.controller.request.AjusteEstoqueRequest;
import br.com.fiap.core.domain.Produto;
import br.com.fiap.core.usecase.estoque.AjustarEstoqueUseCase;
import br.com.fiap.adapter.exception.ProdutoNaoEncontradoException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/estoque")
public class EstoqueResource {

    @Inject
    AjustarEstoqueUseCase ajustarEstoqueUseCase;

    @PUT
    @Path("/ajustar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ajustarEstoque(@PathParam("id") Long id, AjusteEstoqueRequest request) {
        if (request == null || request.getQuantidade() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("A requisição não está completa: Quantidade não informada.").build();
        }
        try {
            Produto produto = ajustarEstoqueUseCase.executar(id, request.getQuantidade());
            if (produto == null) {
                throw new ProdutoNaoEncontradoException(id);
            }
            String mensagem = "Produto: " + produto.nome() + ", Quantidade atualizada: " + produto.quantidade();
            return Response.ok(mensagem).build();
        } catch (ProdutoNaoEncontradoException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao ajustar o estoque.").build();
        }
    }
}