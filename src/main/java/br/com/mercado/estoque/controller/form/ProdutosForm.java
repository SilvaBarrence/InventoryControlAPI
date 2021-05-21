package br.com.mercado.estoque.controller.form;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

import br.com.mercado.estoque.models.Produtos;

public class ProdutosForm {

	private Long id;

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	private Long quantity;

	@NotNull
	private Double value;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Produtos convert() {
		return new Produtos(name, quantity, value);
	}

}
