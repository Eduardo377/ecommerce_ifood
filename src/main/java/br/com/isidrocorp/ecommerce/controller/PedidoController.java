package br.com.isidrocorp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.ecommerce.model.Pedido;
import br.com.isidrocorp.ecommerce.services.IPedidoService;
import br.com.isidrocorp.ecommerce.util.Mensagem;

@RestController
public class PedidoController {
	
	@Autowired
	private IPedidoService service;
	
	@PostMapping("/pedidos")
	public ResponseEntity<?> inserirNovo(@RequestBody Pedido novo){
		Pedido resultado = service.adicionarPedido(novo);
		if (resultado != null) { // inseriu, ufa!
			return ResponseEntity.status(201).body(resultado);
		}
		return ResponseEntity.status(400).body(new Mensagem(9876, "Dados invalidos para a estrutura pedido"));		
	}
	
	
	
//	@Autowired
//	private PedidoDAO dao;
//	
//	@GetMapping("/pedidos")
//	public List<Pedido> recuperarTodos(){
//		return (List<Pedido>)dao.findAll();
//	}
//	
//	@GetMapping("/faturamento/{ano}")
//	public List<Faturamento> recuperarFaturamento(@PathVariable int ano){
//		return dao.recuperarFaturamentoPorAno(ano);
//	}

}
