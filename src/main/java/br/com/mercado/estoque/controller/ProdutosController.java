package br.com.mercado.estoque.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercado.estoque.controller.dto.ProdutoDTO;
import br.com.mercado.estoque.models.Produtos;
import br.com.mercado.estoque.repository.ProdutosRepository;

@RestController
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepostory;

	@RequestMapping("/Produtos")
	public List<ProdutoDTO> list() {
		List<Produtos> produtos = produtosRepostory.findAll();
		return ProdutoDTO.converter(produtos);
	}
}
