package br.com.isidrocorp.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.ecommerce.dao.DepartamentoDAO;
import br.com.isidrocorp.ecommerce.model.Departamento;

@RestController
public class DepartamentoController {
	
	@Autowired  // Autowired indica que o objeto dao não será dado NEW nele de forma explícita e
	            // ele ainda vai buscar um objeto que possa implementar a lógica da interface
	private DepartamentoDAO dao;
	
	@GetMapping("/departamentos")
	public List<Departamento> recuperarTodos(){
		return (List<Departamento>)dao.findAll();
	}
	
	

}
