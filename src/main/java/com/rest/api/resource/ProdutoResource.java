package com.rest.api.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	private List<Produto> listaDeProdutos;
	
	public ProdutoResource() {
		listaDeProdutos = new ArrayList<>();
		
		Produto p1 = new Produto();
		p1.setCodigo(1L);
		p1.setNome("Arroz");
		p1.setCodigoBarras("7890998097");
		
		Produto p2 = new Produto();
		p2.setCodigo(2L);
		p2.setNome("Feijão");
		p2.setCodigoBarras("7890998123");
		
		Produto p3 = new Produto();
		p3.setCodigo(3L);
		p3.setNome("Macarrão");
		p3.setCodigoBarras("7890998888");
		
		listaDeProdutos.add(p1);
		listaDeProdutos.add(p2);
		listaDeProdutos.add(p3);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listar(){
		return new ResponseEntity<List<Produto>>(listaDeProdutos, HttpStatus.OK);
	}

}
