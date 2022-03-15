package br.com.isidrocorp.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isidrocorp.ecommerce.dao.ClienteDAO;
import br.com.isidrocorp.ecommerce.dto.ClienteDTO;

@Component
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteDAO dao;
	
	@Override
	public List<ClienteDTO> recuperarTodos() {
		// TODO Auto-generated method stub
		return dao.recuperarTodos(); 
	}

	@Override
	public ClienteDTO recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.recuperarPeloId(id);
	}
	

}
