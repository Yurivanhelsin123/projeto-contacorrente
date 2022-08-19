package br.com.cursopreparatorio.service;


import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursopreparatorio.entity.Disciplina;
import br.com.cursopreparatorio.repository.DisciplinaRepository;




@Service
public class DisciplinaService {

	
	
	@Autowired
	DisciplinaRepository disciplinaRepo;
	
	public List<Disciplina> ListaTodasDisciplinas(){
		
		return disciplinaRepo.findAll();		
		
		
	}
	
	
	public Disciplina buscaPorID(Integer id)  throws ObjectNotFoundException{
				Optional<Disciplina> disciplina = disciplinaRepo.findById(id);
		
		return disciplina.orElseThrow(() -> new ObjectNotFoundException(null , "Disciplina não encontrada"));
	}
	
	public  Disciplina salvar(Disciplina disciplina) {
		return disciplinaRepo.save(disciplina);
	}
	
	public void excluir(Integer id) {
		
		disciplinaRepo.deleteById(id);
	}
	
	
	public Disciplina alterar(Disciplina  objdisciplina) {
		
		Disciplina disciplina = buscaPorID(objdisciplina.getId());
		disciplina.setNomedadisciplina(objdisciplina.getNomedadisciplina() );
		return salvar(disciplina);
		
		
	}
	

}

