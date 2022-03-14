package br.com.isidrocorp.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.ecommerce.model.Departamento;
import br.com.isidrocorp.ecommerce.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer>{

	//	aqui virão as minhas consultas customizadas
	// quero uma busca que traga produtos por palavra chave
	
	public List<Produto> findByNomeContainingOrDescricaoContaining(String pcNome, String pcDescricao);
	public List<Produto> findByOrderByNomeAsc();
	public List<Produto> findByOrderByPrecoAsc();
	public List<Produto> findByOrderByPrecoDesc();
	public List<Produto> findByDepto(Departamento d);

}

