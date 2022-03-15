package br.com.isidrocorp.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isidrocorp.ecommerce.dao.PedidoDAO;
import br.com.isidrocorp.ecommerce.model.ItemPedido;
import br.com.isidrocorp.ecommerce.model.Pedido;

@Component
public class PedidoServiceImpl implements IPedidoService {

	@Autowired
	private PedidoDAO dao;
	
	@Override
	public Pedido adicionarPedido(Pedido novo) {
		// TODO Auto-generated method stub
		for(ItemPedido item: novo.getItens()) {
			item.setPedido(novo);
		}
		Pedido resultado = dao.save(novo);
		return resultado;
	}

}
