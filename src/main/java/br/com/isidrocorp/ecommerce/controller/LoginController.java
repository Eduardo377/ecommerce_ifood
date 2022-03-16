package br.com.isidrocorp.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.ecommerce.model.Usuario;
import br.com.isidrocorp.ecommerce.security.Token;
import br.com.isidrocorp.ecommerce.security.TokenUtil;

@RestController
public class LoginController {
	
	@GetMapping("/testelogin")
	public ResponseEntity<Token> fazerLoginFake(){
		Usuario u = new Usuario();
		u.setUsername("isidro");
		u.setEmail("isidro@isidro.com");
		u.setNomeCompleto("Professor Isidro");
		Token t = new Token(TokenUtil.createToken(u));
		return ResponseEntity.ok(t);
	}

}
