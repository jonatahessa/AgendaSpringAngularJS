package com.jonata.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonata.agenda.domain.Contato;
import com.jonata.agenda.repositories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repo;

	public Contato insert(Contato obj) {
		return repo.save(obj);
	}

	public List<Contato> listar() {
		List<Contato> contatos = repo.findAll();
		return contatos;
	}
	
	public void delete(Contato obj) {
		repo.delete(obj);
	}
}
