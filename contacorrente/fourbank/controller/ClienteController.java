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

import com.contacorrente.fourbank.entity.Cliente;
import com.contacorrente.fourbank.service.ClienteService;

@RestController
@RequestMapping("/cliente")
	public class ClienteController {



	
		@Autowired
		private ClienteService clienteservice;
		@RequestMapping(method=RequestMethod.GET)		
		public ResponseEntity<List<Cliente>> ListarClientes(){
		List<Cliente> clientes	=clienteservice.ListarClientes();
			return ResponseEntity.ok().body(clientes);
			
		}
		
		
		@RequestMapping(value="/{idcliente}", method = RequestMethod.GET)
		public ResponseEntity<Cliente>  buscaPorID(@PathVariable Integer idcliente) throws ObjectNotFoundException{
			Cliente cliente = clienteservice.buscaPorID(idcliente);
			return ResponseEntity.ok().body(cliente);
		}
		
		
		
	

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Void> inserir(@RequestBody @Valid Cliente objCliente){
			Cliente cliente = clienteservice.salvar(objCliente);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idcliente}").buildAndExpand(cliente.getIdcliente()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value="/{idcliente}", method = RequestMethod.DELETE)
		public ResponseEntity<Void> excluir(@PathVariable Integer idcliente){
			clienteservice.excluir(idcliente);
			return ResponseEntity.noContent().build();
			
		}
		@RequestMapping(value="/{idcliente}" , method = RequestMethod.PUT)
		public ResponseEntity<Void> alterar(@RequestBody Cliente objCliente,@PathVariable Integer idcliente){
			objCliente.setIdcliente(idcliente);
			clienteservice.alterar(objCliente);
			return ResponseEntity.noContent().build();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	




