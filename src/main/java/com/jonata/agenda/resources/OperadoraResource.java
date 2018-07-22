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

import com.jonata.agenda.domain.Operadora;
import com.jonata.agenda.services.OperadoraService;

@RestController
@RequestMapping(value = "/operadoras")
public class OperadoraResource {

	@Autowired
	private OperadoraService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<Operadora> operadoras = service.listar();
		return ResponseEntity.ok().body(operadoras);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Operadora obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
