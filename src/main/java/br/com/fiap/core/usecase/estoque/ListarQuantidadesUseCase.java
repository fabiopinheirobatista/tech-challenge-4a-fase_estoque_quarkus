package br.com.fiap.core.usecase.estoque;

import br.com.fiap.adapter.persistence.produto.ProdutoRepository;
import br.com.fiap.core.domain.Produto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ListarQuantidadesUseCase {

    @Inject
    ProdutoRepository produtoRepository;

    public List<Produto> executar() {
        return produtoRepository.listarTodos();
    }

}
