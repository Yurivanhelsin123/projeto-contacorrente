package br.com.cursopreparatorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursopreparatorio.entity.AlunoDisciplina;
import br.com.cursopreparatorio.entity.Avaliacao;






@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao,AlunoDisciplina>{

	
	Avaliacao findByAlunoDisciplina(AlunoDisciplina alunoDisciplina);
	
	
	
	
	
	
	
}
