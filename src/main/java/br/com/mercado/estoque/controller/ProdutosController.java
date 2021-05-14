package br.com.mercado.estoque.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercado.estoque.controller.dto.ProdutoDTO;
import br.com.mercado.estoque.models.Produtos;
import br.com.mercado.estoque.repository.ProdutosRepository;

@RestController
@RequestMapping("/Produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepostory;

	@GetMapping
	public List<ProdutoDTO> listAll() {
		List<Produtos> produtos = produtosRepostory.findAll();
		return ProdutoDTO.converter(produtos);
	}
	
	@GetMapping("/{id}")
	public Optional<Produtos> listId(@PathVariable(value = "id") Long id) {
		Optional<Produtos> produtos = produtosRepostory.findById(id);
		if(produtos.get().getQuantity() == 0) {
			System.out.println("Vazio!"); // Solicitar mais produto
		}
		return produtos;
	}

}
