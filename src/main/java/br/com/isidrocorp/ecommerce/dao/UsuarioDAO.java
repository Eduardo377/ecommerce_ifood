package br.com.isidrocorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.ecommerce.model.Usuario;

public interface UsuarioDAO extends CrudRepository <Usuario, Integer>{
	public Usuario findByUsernameOrEmail(String username, String email);

}
