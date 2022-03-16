package br.com.isidrocorp.ecommerce.services;

import br.com.isidrocorp.ecommerce.model.Usuario;
import br.com.isidrocorp.ecommerce.security.Token;

public interface IUsuarioService {
	public Token gerarTokenDeUsuarioLogado(Usuario dadosLogin);

}
