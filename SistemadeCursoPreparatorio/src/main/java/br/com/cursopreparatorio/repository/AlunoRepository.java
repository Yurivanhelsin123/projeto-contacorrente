package br.com.cursopreparatorio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cursopreparatorio.entity.Aluno;



@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
