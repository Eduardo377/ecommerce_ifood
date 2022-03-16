package br.com.isidrocorp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.ecommerce.model.Usuario;
import br.com.isidrocorp.ecommerce.security.Token;
import br.com.isidrocorp.ecommerce.security.TokenUtil;
import br.com.isidrocorp.ecommerce.services.IUsuarioService;

@RestController
public class LoginController {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/testelogin")
	public ResponseEntity<Token> fazerLoginFake(){
		return null;
	}

}
