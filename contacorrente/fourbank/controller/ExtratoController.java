package com.contacorrente.fourbank.controller;

import java.net.URI;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.contacorrente.fourbank.entity.Extrato;
import com.contacorrente.fourbank.service.ExtratoService;

@RestController
@RequestMapping("/extrato")
public class ExtratoController {

	@Autowired
	private ExtratoService extratoservice;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Extrato>> ListarExtrato() {
		List<Extrato> extrato = extratoservice.ListarExtrato();
		return ResponseEntity.ok().body(extrato);

	}

	@RequestMapping(value = "/{idextrato}", method = RequestMethod.GET)
	public ResponseEntity<Extrato> buscaPorID(@PathVariable Integer idextrato) throws ObjectNotFoundException {
		Extrato extrato = extratoservice.buscaPorID(idextrato);
		return ResponseEntity.ok().body(extrato);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Extrato objExtrato) {
		Extrato extrato = extratoservice.salvar(objExtrato);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idextrato}")
				.buildAndExpand(extrato.getIdextrato()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{idextrato}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer idextrato) {
		extratoservice.excluir(idextrato);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{idextrato}", method = RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Extrato objExtrato, @PathVariable Integer idextrato) {
		objExtrato.setIdextrato(idextrato);
		extratoservice.alterar(objExtrato);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
