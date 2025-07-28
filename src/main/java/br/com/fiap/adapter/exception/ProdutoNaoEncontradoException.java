package br.com.fiap.adapter.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class ProdutoNaoEncontradoException extends WebApplicationException {
    public ProdutoNaoEncontradoException(Long id) {
        super("Produto com ID " + id + " não foi encontrado.", Response.Status.NOT_FOUND);
    }
}