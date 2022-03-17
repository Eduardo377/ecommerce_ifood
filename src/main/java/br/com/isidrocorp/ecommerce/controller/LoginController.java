package br.com.isidrocorp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.ecommerce.dto.UsuarioLoginDTO;
import br.com.isidrocorp.ecommerce.security.Token;
import br.com.isidrocorp.ecommerce.services.IUsuarioService;

@RestController
public class LoginController {
	
	@Autowired
	private IUsuarioService service;
	
	@PostMapping("/login")
	public ResponseEntity<Token> realizarLogin(@RequestBody UsuarioLoginDTO dadosLogin ){
		Token token = service.gerarTokenDeUsuarioLogado(dadosLogin);
		if (token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(401).build();
	}
	

}
