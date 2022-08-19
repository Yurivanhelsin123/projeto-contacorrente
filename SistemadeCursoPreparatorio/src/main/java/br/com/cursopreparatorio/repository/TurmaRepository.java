package br.com.cursopreparatorio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursopreparatorio.entity.Turma;




	@Repository
	public interface TurmaRepository extends JpaRepository<Turma, Integer> {
		
}
