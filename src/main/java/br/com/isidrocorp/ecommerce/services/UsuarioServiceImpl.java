package br.com.isidrocorp.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isidrocorp.ecommerce.dao.UsuarioDAO;
import br.com.isidrocorp.ecommerce.model.Usuario;
import br.com.isidrocorp.ecommerce.security.Token;

@Component
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private UsuarioDAO dao; 
	
	@Override
	public Token gerarTokenDeUsuarioLogado(Usuario dadosLogin) {
		// TODO Auto-generated method stub
		return null;
	}

}
