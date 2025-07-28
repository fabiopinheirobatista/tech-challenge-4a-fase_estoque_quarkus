package br.com.fiap.adapter.persistence.produto;

import br.com.fiap.core.domain.Produto;
import java.util.List;

public interface ProdutoRepository {
    List<Produto> listarTodos();
}