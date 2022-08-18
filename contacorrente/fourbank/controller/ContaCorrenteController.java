package com.contacorrente.fourbank.controller;

import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.contacorrente.fourbank.entity.ContaCorrente;
import com.contacorrente.fourbank.entity.Extrato;
//import com.contacorrente.fourbank.entity.Extrato;
import com.contacorrente.fourbank.erros.ExceptionCustom;
import com.contacorrente.fourbank.service.ContaCorrenteService;

@RestController
@RequestMapping("/contacorrente")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteService contacorrenteservice;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ContaCorrente>> ListarContas() {
		List<ContaCorrente> contacorrente = contacorrenteservice.ListarContas();
		return ResponseEntity.ok().body(contacorrente);

	}

	@RequestMapping(value = "/{idcontacorrente}", method = RequestMethod.GET)
	public ResponseEntity<ContaCorrente> buscaPorID(@PathVariable Integer idcontacorrente)
			throws ObjectNotFoundException {
		ContaCorrente contacorrente = contacorrenteservice.buscaPorID(idcontacorrente);
		return ResponseEntity.ok().body(contacorrente);
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody ContaCorrente objContaCorrente){
		ContaCorrente contacorrente = contacorrenteservice.salvar(objContaCorrente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idcontacorrente}").buildAndExpand(contacorrente.getIdcontacorrente()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	

	@RequestMapping(value = "/{idcontacorrente}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer idcontacorrente) {
		contacorrenteservice.excluir(idcontacorrente);
		return ResponseEntity.noContent().build();

	}

//	@RequestMapping(value = "/{idcontacorrente}", method = RequestMethod.PUT)
//	public ResponseEntity<Void> alterar(@RequestBody ContaCorrente objContacorrente,
//			@PathVariable Integer idcontacorrente) {
//		objContacorrente.setIdcontacorrente(idcontacorrente);
//		contacorrenteservice.alterar(objContacorrente);
//		return ResponseEntity.noContent().build();
//	}

	
	 @RequestMapping(method = RequestMethod.PUT, path="depositar/{quantidade}/{idcontacorrente}")
	public ResponseEntity<?> depositar(@PathVariable double quantidade, @PathVariable Integer idcontacorrente){
		
		this.contacorrenteservice.depositar(quantidade, idcontacorrente);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	 @RequestMapping(method = RequestMethod.PUT, path="sacar/{quantidade}/{idcontacorrente}")
	public ResponseEntity<?> sacar(@PathVariable double quantidade, @PathVariable Integer idcontacorrente){
	      if(quantidade <= 0) {
      throw new ExceptionCustom("valor incorreto,Qual valor deseja sacar ");
    	  
    	  
	      }
	
        this.contacorrenteservice.sacar(quantidade, idcontacorrente);
	        return new ResponseEntity<>(HttpStatus.OK);
			
	 }
	
	
	@RequestMapping(method = RequestMethod.GET, path="extratoConta/{idcontacorrente}")
	public ResponseEntity<?>  extratoConta(@PathVariable Integer idcontacorrente){
		
	List<Extrato> extratos = contacorrenteservice.extratoConta(idcontacorrente);
	
	return new ResponseEntity<>(extratos,HttpStatus.OK);
		
		
}
	
	
	
	
	
	
	
	
	
	
	
}
