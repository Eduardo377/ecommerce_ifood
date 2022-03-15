package br.com.isidrocorp.ecommerce.services;

import java.util.List;

import br.com.isidrocorp.ecommerce.dto.ClienteDTO;

public interface IClienteService {
	public List<ClienteDTO> recuperarTodos();
	public ClienteDTO recuperarPeloId(Integer id);	
}
