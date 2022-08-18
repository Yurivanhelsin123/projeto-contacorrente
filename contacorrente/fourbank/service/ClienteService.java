package com.contacorrente.fourbank.service;

import java.util.List;
import java.util.Optional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contacorrente.fourbank.entity.Cliente;
import com.contacorrente.fourbank.repository.ClienteRepository;





@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienterepo;

	
	public List<Cliente> ListarClientes(){
		return clienterepo.findAll();
		
	}
	
	
	
	
	
	
	
	public Cliente buscaPorID(Integer idcliente) throws ObjectNotFoundException{
		 
		Optional<Cliente>  cliente = clienterepo.findById(idcliente);
		return cliente.orElseThrow(()-> new ObjectNotFoundException(null, "Algo deu errado ,cliente não encontrado"));
	}
	
	
	
	
//	public Cliente buscaNome(String clientenome) throws ObjectNotFoundException{
//		 
//		Optional<Cliente>  clientes = clienterepo.findByClientenome(clientenome);
//		return clientes.orElseThrow(()-> new ObjectNotFoundException(null, " cliente não encontrado"));
//	}
//	
	
	
	
	
	
	
	

	public Cliente salvar(Cliente cliente) {
		return clienterepo.save(cliente);
		
	}
	
	
	public void excluir(Integer idcliente) {
		clienterepo.deleteById(idcliente);
		
	}
	
	

	public Cliente alterar(Cliente objcliente ) {
		Cliente cliente = buscaPorID(objcliente.getIdcliente());
		cliente.setClientenome(objcliente.getClientenome());
		cliente.setClientecpf(objcliente.getClientecpf());
		cliente.setClientefone(objcliente.getClientefone());
		return salvar(cliente);
		
		
		
	}
	
	

		
}  