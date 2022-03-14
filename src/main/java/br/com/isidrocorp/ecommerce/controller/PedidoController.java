package br.com.isidrocorp.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.ecommerce.dao.PedidoDAO;
import br.com.isidrocorp.ecommerce.model.Pedido;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoDAO dao;
	
	@GetMapping("/pedidos")
	public List<Pedido> recuperarTodos(){
		return (List<Pedido>)dao.findAll();
	}

}
