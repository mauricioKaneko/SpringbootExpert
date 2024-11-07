package br.com.kaneko.produtosapi.repository;

import br.com.kaneko.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
