package br.com.isidrocorp.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.ecommerce.dao.ProdutoDAO;
import br.com.isidrocorp.ecommerce.model.Produto;

@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@GetMapping("/produtos")
	public List<Produto> recuperarTodos(){
		// qual o objetivo aqui? Recuperar todos os produtos do banco
		return (List<Produto>)dao.findAll();
	}


}
