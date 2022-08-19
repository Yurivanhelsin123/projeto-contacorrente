package br.com.cursopreparatorio.inicializacao;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.cursopreparatorio.entity.Aluno;
import br.com.cursopreparatorio.entity.AlunoDisciplina;
import br.com.cursopreparatorio.entity.Avaliacao;
import br.com.cursopreparatorio.entity.Disciplina;
import br.com.cursopreparatorio.entity.Turma;
import br.com.cursopreparatorio.repository.AlunoRepository;
import br.com.cursopreparatorio.repository.DisciplinaRepository;
import br.com.cursopreparatorio.repository.TurmaRepository;
import br.com.cursopreparatorio.service.AvaliacaoService;


@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
		@Autowired			
		AlunoRepository alunoRepo;	
		@Autowired 
		TurmaRepository turmaRepo;
		@Autowired 
		DisciplinaRepository disciplinaRepo;
		@Autowired
		AvaliacaoService avaliacaoService;
		
		public void onApplicationEvent(ContextRefreshedEvent event) {
			
			 Aluno aluno1= new Aluno();
			 aluno1.setNome("Lucas Moreira");
			 
			 Aluno aluno2= new Aluno();
			 aluno2.setNome("Rafael de Catro Souza");	
			 
			 Aluno aluno3= new Aluno();
			 aluno3.setNome("Rayane Silva");	
			 
			 Aluno aluno4= new Aluno();
			 aluno4.setNome("Yuri Yokada");
						
			 Aluno aluno5= new Aluno();
			 aluno5.setNome("Miriam Martins");			
			
			 Aluno aluno6= new Aluno();
			 aluno6.setNome("Letícia Almeida");
			
			//alunoRepo.saveAll(Arrays.asList(aluno1,aluno2,aluno3,aluno4,aluno5,aluno6));

			
			Turma turma1= new Turma();
			 turma1.setNomedaturma("Análise de Sistemas");
			 
			 Turma turma2= new Turma();
			 turma2.setNomedaturma("Administração");
			 
			
			 Turma turma3= new Turma();
			 turma3.setNomedaturma("Pedagogia");
			 
			
			 Turma turma4= new Turma();
			 turma4.setNomedaturma("Engenharia mecânica");
			
			
			 Turma turma5= new Turma();
			 turma5.setNomedaturma("Filosofia");
			
			
			 Turma turma6= new Turma();
			 turma6.setNomedaturma("Licenciatura em Matemática");
			 
			 
			 

				 Disciplina disciplina1= new Disciplina();
				 disciplina1.setNomedadisciplina("Java");
				 
				 Disciplina disciplina2= new Disciplina();
				 disciplina2.setNomedadisciplina("Python");
				 
				 Disciplina disciplina3= new Disciplina();
				 disciplina3.setNomedadisciplina("Empreendedorismo");	
				 
				 Disciplina disciplina4= new Disciplina();
				 disciplina4.setNomedadisciplina("Resistência dos materiais");	
				 
				 
				 Disciplina disciplina5= new Disciplina();
				 disciplina5.setNomedadisciplina("matemática1");	
				 
				 Disciplina disciplina6= new Disciplina();
				 disciplina6.setNomedadisciplina("matematica2");	
				 
				 disciplinaRepo.saveAll(Arrays.asList(disciplina1,disciplina2,disciplina3,disciplina4,disciplina5,disciplina6));
	
				aluno1.setDisciplinas(Arrays.asList(disciplina5,disciplina6));
				aluno2.setDisciplinas(Arrays.asList());
				aluno3.setDisciplinas(Arrays.asList(disciplina4));
				aluno4.setDisciplinas(Arrays.asList(disciplina1,disciplina2));
				aluno5.setDisciplinas(Arrays.asList(disciplina3));
				aluno6.setDisciplinas(Arrays.asList());				
				
			 turmaRepo.saveAll(Arrays.asList(turma1,turma2,turma3,turma4,turma5,turma6));						 		 
			 
			 aluno1.setTurma(turma6);
			 aluno2.setTurma(turma5);
			 aluno3.setTurma(turma4);
			 aluno4.setTurma(turma1);
			 aluno5.setTurma(turma2);
			 aluno6.setTurma(turma3);
			 
			 
			 
			 alunoRepo.saveAll(Arrays.asList(aluno1,aluno2,aluno3,aluno4,aluno5,aluno6));
			 
			 Avaliacao avaliacaoAluno1 = new Avaliacao();	
				
			 AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
			 alunoDisciplina.setAluno(aluno1);
			 alunoDisciplina.setDisciplina(disciplina6);					
			 avaliacaoAluno1.setAlunoDisciplina(alunoDisciplina);
			 avaliacaoAluno1.setConceito("A");
			 avaliacaoService.save(avaliacaoAluno1);
			 				
			 				
            AlunoDisciplina yurijava = new AlunoDisciplina();
            yurijava.setAluno(aluno4);
            yurijava.setDisciplina(disciplina1);
            Avaliacao avaliacaoyurijava = new Avaliacao();
            avaliacaoyurijava.setAlunoDisciplina(yurijava);
             avaliacaoyurijava.setConceito("B");

			avaliacaoService.save(avaliacaoyurijava);
				
		
			
			Avaliacao aval = avaliacaoService.buscarNotaAlunoDisciplina(alunoDisciplina);
			System.out.println("Avaliacao " + aval.getConceito());
			System.out.println("Disciplina " + aval.getAlunoDisciplina().getDisciplina());
			System.out.println("Aluno " + aval.getAlunoDisciplina().getAluno().getNome());
			
		}
		
		
		
		

	}

