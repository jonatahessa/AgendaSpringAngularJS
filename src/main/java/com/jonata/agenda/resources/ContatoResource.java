package com.jonata.agenda.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jonata.agenda.domain.Contato;
import com.jonata.agenda.services.ContatoService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {

	@Autowired
	private ContatoService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<Contato> contatos = service.listar();
		return ResponseEntity.ok().body(contatos);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Contato obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public void delete(@RequestBody List<Contato> contatos) {
		for (Contato c : contatos) {
			service.delete(c);
		}
	}
}
