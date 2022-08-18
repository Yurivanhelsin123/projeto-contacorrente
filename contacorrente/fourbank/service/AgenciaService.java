package com.contacorrente.fourbank.service;





	import java.util.List;
	import java.util.Optional;
	import org.hibernate.ObjectNotFoundException;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.contacorrente.fourbank.entity.Agencia;
import com.contacorrente.fourbank.repository.AgenciaRepository;






	@Service
	public class AgenciaService {



		@Autowired
		AgenciaRepository agenciarepo;
		
		public List<Agencia> ListarAgencia(){
			return agenciarepo.findAll();
			
		}
		
		
		
		
		
		
		
		public Agencia buscaPorID(Integer idagencia) throws ObjectNotFoundException{
			 
			Optional<Agencia>  agencia = agenciarepo.findById(idagencia);
			return agencia.orElseThrow(()-> new ObjectNotFoundException(null, "Algo deu errado ,agencia não encontrado"));
		}
		
		

		public Agencia salvar(Agencia agencia) {
			return agenciarepo.save(agencia);
			
		}
		
		
		public void excluir(Integer idagencia) {
			agenciarepo.deleteById(idagencia);
			
		}
		
		

		public Agencia alterar(Agencia objagencia ) {
			Agencia agencia = buscaPorID(objagencia.getIdagencia());
			agencia.setNumerobanco(objagencia.getNumerobanco());
			agencia.setNumeroagencia(objagencia.getNumeroagencia());
			agencia.setNomeagencia(objagencia.getNomeagencia());
			agencia.setEndereco(objagencia.getEndereco());
			agencia.setTelefone(objagencia.getTelefone());
			
		
			return salvar(agencia);
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}

