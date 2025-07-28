package br.com.fiap.core.usecase.estoque;

import jakarta.enterprise.context.ApplicationScoped;

import br.com.fiap.core.domain.Produto;
import br.com.fiap.core.gateway.EstoqueGateway;

@ApplicationScoped
public class AjustarEstoqueUseCase {
    private final EstoqueGateway gateway;

    public AjustarEstoqueUseCase(EstoqueGateway gateway) {
        this.gateway = gateway;
    }

    public Produto executar(Long produtoId, int quantidade) {
        Produto produto = gateway.buscarPorId(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Produto produtoAtualizado = new Produto(
                produto.id(),
                produto.nome(),
                produto.quantidade() + quantidade
        );
        return gateway.salvar(produtoAtualizado);
    }
}