package br.com.fiap.adapter.persistence.produto;

import br.com.fiap.adapter.exception.NenhumProdutoEncontradoException;
import br.com.fiap.core.domain.Produto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Override
    public List<Produto> listarTodos() {
        List<Produto> produtos = List.of();
        if (produtos.isEmpty()) {
            throw new NenhumProdutoEncontradoException();
        }
        return produtos;
    }

}