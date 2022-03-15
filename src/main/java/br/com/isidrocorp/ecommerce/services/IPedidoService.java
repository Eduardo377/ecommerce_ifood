package br.com.isidrocorp.ecommerce.services;

import br.com.isidrocorp.ecommerce.model.Pedido;

public interface IPedidoService {
	// recebo um parâmetro do tipo pedido (sem numero) e retorno o mesmo objeto agora criado no banco
	public Pedido adicionarPedido(Pedido novo);

}
