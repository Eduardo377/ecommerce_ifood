package br.com.isidrocorp.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isidrocorp.ecommerce.dao.UsuarioDAO;
import br.com.isidrocorp.ecommerce.dto.UsuarioLoginDTO;
import br.com.isidrocorp.ecommerce.model.Usuario;
import br.com.isidrocorp.ecommerce.security.EcommerceCrypto;
import br.com.isidrocorp.ecommerce.security.Token;
import br.com.isidrocorp.ecommerce.security.TokenUtil;

@Component
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private UsuarioDAO dao;

	@Override
	public Token gerarTokenDeUsuarioLogado(UsuarioLoginDTO dadosLogin) {
		// TODO Auto-generated method stub
		Usuario user = dao.findByUsernameOrEmail(dadosLogin.getUsername(), dadosLogin.getEmail());
		try {
			System.out.println("DEBUG = " + EcommerceCrypto.encrypt(dadosLogin.getSenha()));

			if (user != null) { // usuario existe no banco

				// do ponto que estamos para uma senha criptografada, basta apenas
				// criptografarmos
				// a senha recebida e comparar os valores criptografados

				if (user.getSenha().equals(dadosLogin.getSenha())) {
					return new Token(TokenUtil.createToken(user));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

}
