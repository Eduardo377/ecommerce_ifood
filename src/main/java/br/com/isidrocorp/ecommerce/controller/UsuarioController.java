package br.com.isidrocorp.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.ecommerce.model.Usuario;
import br.com.isidrocorp.ecommerce.services.IUsuarioService;
import br.com.isidrocorp.ecommerce.util.Mensagem;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> cadastrarNovoUsuario(@RequestBody Usuario novo){
		Usuario res = service.criarUsuario(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().body(new Mensagem(987465, "Dados Invalidos"));
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> alterarDados(@RequestBody Usuario dados, @PathVariable Integer id){
		dados.setIdUsuario(id);
		Usuario res = service.alterarDados(dados);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().body(new Mensagem(123456, "Dados invalidos para atualizacao"));
	}

}
