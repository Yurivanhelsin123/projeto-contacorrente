package br.com.cursopreparatorio.service;




import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursopreparatorio.entity.Turma;
import br.com.cursopreparatorio.repository.TurmaRepository;






@Service
public class TurmaService {

	
	
	@Autowired
	TurmaRepository turmaRepo;
	public List<Turma> ListaTodasTurmas(){
		return turmaRepo.findAll();		
		
		
	}
	
	
	public Turma buscaPorID(Integer id)  throws ObjectNotFoundException{
		Optional<Turma> turma = turmaRepo.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(null, "Não Encontrado"));
		
		
		
	}
	
	public Turma salvar(Turma turma) {
		return turmaRepo.save(turma);
		
		
	}
	
	public void excluir(Integer id) {
		turmaRepo.deleteById(id);
		
		
	}
	
	public Turma alterar(Turma objturma) {
		Turma turma= buscaPorID(objturma.getId());
		turma.setNomedaturma(objturma.getNomedaturma());
		return salvar(turma);
		
		
	}
	
	
}

