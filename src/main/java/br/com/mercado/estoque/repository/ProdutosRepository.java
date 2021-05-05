package br.com.mercado.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercado.estoque.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	
}
