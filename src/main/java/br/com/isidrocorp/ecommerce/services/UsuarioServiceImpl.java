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

			if (user != null) { // usuario existe no banco

				// do ponto que estamos para uma senha criptografada, basta apenas
				// criptografarmos
				// a senha recebida e comparar os valores criptografados
				String senhaLogin = EcommerceCrypto.encrypt(dadosLogin.getSenha());
				
				System.out.println("Senha login = "+senhaLogin);
				System.out.println("Senha user  = "+user.getSenha());
			
				if (senhaLogin.equals(user.getSenha())) {
					return new Token(TokenUtil.createToken(user));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public Usuario criarUsuario(Usuario novo) {
		// TODO Auto-generated method stub
		try {
			if (novo.getSenha() != null) {
				novo.setSenha(EcommerceCrypto.encrypt(novo.getSenha()));
				dao.save(novo);
				return novo;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario alterarDados(Usuario dados) {
		try {
			if (dados.getSenha() != null) {
				dados.setSenha(EcommerceCrypto.encrypt(dados.getSenha()));
				dao.save(dados);
				return dados;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
