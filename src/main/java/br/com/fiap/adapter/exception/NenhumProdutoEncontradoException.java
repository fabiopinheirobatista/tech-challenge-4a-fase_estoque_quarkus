package br.com.fiap.adapter.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class NenhumProdutoEncontradoException extends WebApplicationException {
    public NenhumProdutoEncontradoException() {
        super("Nenhum produto encontrado.", Response.Status.NOT_FOUND);
    }
}