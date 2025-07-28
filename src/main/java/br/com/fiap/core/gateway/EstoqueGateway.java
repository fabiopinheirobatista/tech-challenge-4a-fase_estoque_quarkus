package br.com.fiap.core.gateway;

import br.com.fiap.core.domain.Produto;
import java.util.Optional;

public interface EstoqueGateway {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(Long id);
}