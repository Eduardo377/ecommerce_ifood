package br.com.isidrocorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.ecommerce.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

}
