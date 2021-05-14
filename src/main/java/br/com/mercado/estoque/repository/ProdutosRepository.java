package br.com.mercado.estoque.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercado.estoque.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	Optional<Produtos> findById(Long id);
}
