package com.contacorrente.fourbank.service;


	import java.util.List;
	import java.util.Optional;
	import org.hibernate.ObjectNotFoundException;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.contacorrente.fourbank.entity.ContaCorrente;
//import com.contacorrente.fourbank.entity.ContaCorrente;
import com.contacorrente.fourbank.entity.Extrato;

import com.contacorrente.fourbank.repository.ExtratoRepository;





	@Service
	public class ExtratoService {

		@Autowired
		ExtratoRepository extratorepo;
		
		public List<Extrato> ListarExtrato(){
			return extratorepo.findAll();
			
		}
		
		
		
		
		
		
		
		public Extrato buscaPorID(Integer idextrato) throws ObjectNotFoundException{
			 
			Optional<Extrato>  extrato = extratorepo.findById(idextrato);
			return extrato.orElseThrow(()-> new ObjectNotFoundException(null, "Algo deu errado ,extrato não encontrado"));
		}
		
		

		public Extrato salvar(Extrato extrato) {
			return extratorepo.save(extrato);
			
		}
		
		
		public void excluir(Integer idextrato) {
			extratorepo.deleteById(idextrato);
			
		}
		
		

		public Extrato alterar(Extrato objextrato ) {
			Extrato extrato = buscaPorID(objextrato.getIdextrato());
			extrato.setDatahoramovimento(objextrato.getDatahoramovimento());
			extrato.setOperacao(extrato.getOperacao());
			extrato.setValoroperacao(objextrato.getValoroperacao());			
			return salvar(extrato);
			
			
			
		}
		
		
		
		
	

		
	
	public List<Extrato> buscarContaCorrente(ContaCorrente contacorrente){					
		return extratorepo.findByContacorrente(contacorrente);
	}
	
//				
		
		
	}


