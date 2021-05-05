package br.com.mercado.estoque.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long quantidade;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getQuantidade() {
		return quantidade;
	}

}
