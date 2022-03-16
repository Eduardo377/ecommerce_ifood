package br.com.isidrocorp.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.isidrocorp.ecommerce.dao.PedidoDAO;
import br.com.isidrocorp.ecommerce.model.ItemPedido;
import br.com.isidrocorp.ecommerce.model.Pedido;

public class PedidosServiceImpl implements IPedidoService{
	
	@Autowired
	private PedidoDAO dao;
	
	@Override
	public  Pedido adicionarPedido(Pedido novo) {
		
		for(ItemPedido item: novo.getItens()) {
			item.setPedido(novo);
		}
		Pedido resultado = dao.save(novo);
		return resultado;
	}

	@Override
	public boolean removerPedido(Integer id) {
		// TODO Auto-generated method stub
		try {
			dao.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
