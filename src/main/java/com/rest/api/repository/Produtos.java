package com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {
	
	public Produto findByCodigoBarras(String codigoBarras);

}
