package com.contacorrente.fourbank.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.contacorrente.fourbank.entity.Agencia;
import com.contacorrente.fourbank.service.AgenciaService;

@RestController
@RequestMapping("/agencia")
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaservice;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Agencia>> ListarAgencia() {
		List<Agencia> agencias = agenciaservice.ListarAgencia();
		return ResponseEntity.ok().body(agencias);

	}

	@RequestMapping(value = "/{idagencia}", method = RequestMethod.GET)
	public ResponseEntity<Agencia> buscaPorID(@PathVariable Integer idagencia) throws ObjectNotFoundException {
		Agencia agencia = agenciaservice.buscaPorID(idagencia);
		return ResponseEntity.ok().body(agencia);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody @Valid  Agencia objAgencia) {
		Agencia agencia = agenciaservice.salvar(objAgencia);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idagencia}")
				.buildAndExpand(agencia.getIdagencia()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{idagencia}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer idagencia) {
		agenciaservice.excluir(idagencia);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{idagencia}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Agencia objAgencia, @PathVariable Integer idagencia) {
		objAgencia.setIdagencia(idagencia);
		agenciaservice.alterar(objAgencia);
		return ResponseEntity.noContent().build();
	}

}
