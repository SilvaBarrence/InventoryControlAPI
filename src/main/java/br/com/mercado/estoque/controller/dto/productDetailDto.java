package br.com.mercado.estoque.controller.dto;

import br.com.mercado.estoque.models.Produtos;

public class productDetailDto {

	private Long id;
	private String name;
	private Long quantity;
	private Double value;
	
	public productDetailDto(Produtos produto) {
		this.id = produto.getId();
		this.name = produto.getName();
		this.quantity = produto.getQuantity();
		this.value = produto.getValue();
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

	public Double getValue() {
		return value;
	}
	
	
	
}
