package br.com.fiap.core.domain;

public record Produto(
        Long id,
        String nome,
        int quantidade
) {
}