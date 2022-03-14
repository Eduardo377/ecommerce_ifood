package br.com.isidrocorp.ecommerce.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.ecommerce.model.Departamento;

public interface DepartamentoDAO extends CrudRepository<Departamento, Integer>{
	public List<Departamento> findByOrderByNomeAsc();
}
