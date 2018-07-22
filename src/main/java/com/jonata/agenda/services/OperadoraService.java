package com.jonata.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonata.agenda.domain.Operadora;
import com.jonata.agenda.repositories.OperadoraRepository;

@Service
public class OperadoraService {

	@Autowired
	private OperadoraRepository repo;
	
	public Operadora insert(Operadora obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<Operadora> listar() {
		List<Operadora> operadoras = repo.findAll();
		return operadoras;
	}
}
