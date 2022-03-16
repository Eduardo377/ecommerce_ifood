package br.com.isidrocorp.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.isidrocorp.ecommerce.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

	
	// agora eu quero uma query customizadaaaaaaça (onde EU escrevo o SQL)
	// JPQL - JPa Query Language
	// HQL  - Hibernate Query Language
	// devo pensar em que? Tabelas ou Classes????
	
	@Query(   "SELECT new "
			+ " br.com.isidrocorp.ecommerce.dto.Faturamento( month(pedido.data) , sum(pedido.valorTotal) ) "
			+ " FROM "
			+ " Pedido as pedido where year(pedido.data) = :ano"
			+ " GROUP BY month(pedido.data) ")
	public List<Cliente> recuperarFaturamentoPorAno(@Param ("ano") int ano );
	
