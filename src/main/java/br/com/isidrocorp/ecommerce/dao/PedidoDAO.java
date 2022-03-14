package br.com.isidrocorp.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.ecommerce.dto.Faturamento;
import br.com.isidrocorp.ecommerce.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

	
	// agora eu quero uma query customizadaaaaaaça (onde EU escrevo o SQL)
	// JPQL - JPa Query Language
	// HQL  - Hibernate Query Language
	// devo pensar em que? Tabelas ou Classes????
	
	@Query(   "SELECT new "
			+ " br.com.isidrocorp.ecommerce.dto.Faturamento( month(pedido.data) , sum(pedido.valorTotal) ) "
			+ " FROM "
			+ " Pedido as pedido "
			+ " GROUP BY month(pedido.data) ")
	public List<Faturamento> recuperarFaturamentoPorAno();
	
}
