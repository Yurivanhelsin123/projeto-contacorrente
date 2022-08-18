package com.contacorrente.fourbank.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacorrente.fourbank.entity.ContaCorrente;
import com.contacorrente.fourbank.entity.Extrato;
//import com.contacorrente.fourbank.entity.Extrato;
import com.contacorrente.fourbank.repository.ContacorrenteRepository;


@Service
public class ContaCorrenteService {

	
	@Autowired
	ContacorrenteRepository contacorrenterepo;
	@Autowired
	ExtratoService extratoservice;
	
	public List<ContaCorrente> ListarContas(){
		return contacorrenterepo.findAll();
		
	}
		
	
	public ContaCorrente buscaPorID(Integer idcontacorrente) throws ObjectNotFoundException{
		 
		Optional<ContaCorrente>  contacorrente = contacorrenterepo.findById(idcontacorrente);
		return contacorrente.orElseThrow(()-> new ObjectNotFoundException(null, "Algo deu errado ,conta corrente não encontrada"));
	}
	
	

	public ContaCorrente salvar(ContaCorrente contacorrente) {
		return contacorrenterepo.save(contacorrente);
		
	}
	
	
	public void excluir(Integer idcontacorrente) {
		contacorrenterepo.deleteById(idcontacorrente);
		
	}
	
	


	 
//	    public ContaCorrente alterar(ContaCorrente objcontacorrente ) {
//	    
//			ContaCorrente contacorrente = buscaPorID(objcontacorrente.getIdcontacorrente());				
//		    contacorrente.setSaldocontacorrente(objcontacorrente.getSaldocontacorrente());		    
//		    
//		    
//		     
//			return salvar(contacorrente);
//			
//			
//			
//		}

	
	    public void depositar(double quantidade , Integer idcontacorrente) {
	    	contacorrenterepo.setFixedSaldoFor(quantidade, idcontacorrente);
	    	
	    }

	    public void sacar(double quantidade, Integer idcontacorrente) {
	    	
	    	contacorrenterepo.setFixedSaldo(quantidade, idcontacorrente);
	    }


	    
	    public ContaCorrente VerificarConta(Integer idcontacorrente) {
	    	
	    	return contacorrenterepo.findByIdcontacorrente(idcontacorrente);
	    }
	    
	    
public List<Extrato> extratoConta(Integer idcontacorrente){
	ContaCorrente c = VerificarConta(idcontacorrente);
	return  extratoservice.buscarContaCorrente(c);
		
		
		
	}
	
	

	public void transferir(double quantidade, Integer idcontacorrente) {
		
//		contacorrenterepo.setFixedSaldo(quantidade, idcontacorrente);
//		contacorrenterepo.setFixedSaldoFor(quantidade, idcontacorrente);
    	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

