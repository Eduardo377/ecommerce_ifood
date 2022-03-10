package br.com.isidrocorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.ecommerce.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer>{

	//	aqui virão as minhas consultas customizadas

}
