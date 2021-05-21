package br.com.mercado.estoque.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mercado.estoque.controller.dto.ProdutoDTO;
import br.com.mercado.estoque.controller.dto.productDetailDto;
import br.com.mercado.estoque.controller.form.ProdutosForm;
import br.com.mercado.estoque.controller.form.UpdateProdutosForm;
import br.com.mercado.estoque.models.Produtos;
import br.com.mercado.estoque.repository.ProdutosRepository;

@RestController
@RequestMapping("/Produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;

	@GetMapping
	public List<ProdutoDTO> listAll() {
		List<Produtos> produtos = produtosRepository.findAll();
		return ProdutoDTO.converter(produtos);
	}
	
	@GetMapping("/{id}")
	public productDetailDto listId(@PathVariable Long id) {
		Produtos produtos = produtosRepository.getOne(id);
		if(produtos.getQuantity() == 0) {
			System.out.println("Vazio!");
		}
		if(produtos.getQuantity() <= 5) {
			System.out.println("Produto com baixo estoque."); 
		}
		return new productDetailDto(produtos);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> newProduct(@RequestBody @Valid ProdutosForm form, UriComponentsBuilder uriBuilder) {
		Produtos produtos = form.convert();
		produtosRepository.save(produtos);
		URI uri = uriBuilder.path("/Produtos/{id}").buildAndExpand(produtos.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDTO(produtos));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDTO> updateDetail(@PathVariable Long id, @RequestBody @Valid UpdateProdutosForm form ) {
		Produtos produto = form.update(id, produtosRepository);
		
		return ResponseEntity.ok(new ProdutoDTO(produto));
	}

}
