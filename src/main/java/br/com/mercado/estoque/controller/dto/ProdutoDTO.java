package br.com.mercado.estoque.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mercado.estoque.models.Produtos;

public class ProdutoDTO {

	private Long id;
	private String name;
	private Long quantity;
	
	public ProdutoDTO(Produtos produtos) {
		this.id = produtos.getId();
		this.name = produtos.getName();
		this.quantity = produtos.getQuantity();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public static List<ProdutoDTO> converter(List<Produtos> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}
	
	
}
