package br.com.mercado.estoque.controller.form;

import javax.validation.constraints.NotNull;

import br.com.mercado.estoque.models.Produtos;
import br.com.mercado.estoque.repository.ProdutosRepository;

public class UpdateProdutosForm {

	@NotNull
	private Long quantity;

	private Double value;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Produtos update(Long id, ProdutosRepository produtosRepository) {
		Produtos produtos = produtosRepository.getOne(id);

		if (this.value == null) {
			System.out.println("passou");
			produtos.getValue();
			produtos.setQuantity(this.quantity);
		}else {
			System.out.println("passou aqui na verdade");
			produtos.setValue(this.value);
			produtos.setQuantity(this.quantity);
			
		}
		return produtos;
	}

}
