package br.com.fiap.adapter.persistence.estoque;

import br.com.fiap.core.domain.Produto;
import br.com.fiap.core.gateway.EstoqueGateway;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class EstoqueRepository implements EstoqueGateway, PanacheRepository<Produto> {
    @Override
    public Produto salvar(Produto produto) {
        persistAndFlush(produto);
        return produto;
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return Optional.empty();
    }
}