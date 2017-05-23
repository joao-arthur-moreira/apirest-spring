package com.rest.api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.api.model.Produto;
import com.rest.api.repository.Produtos;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private Produtos produtos;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listar() {
		return new ResponseEntity<List<Produto>>(produtos.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Produto produto){
		produto = produtos.save(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{codigo}").buildAndExpand(produto.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}





