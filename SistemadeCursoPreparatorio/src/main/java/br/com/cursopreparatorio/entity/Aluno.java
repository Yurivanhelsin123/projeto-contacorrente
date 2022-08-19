package br.com.cursopreparatorio.entity;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

	@Entity
	public class Aluno {

	@Id	
		

	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String nome;
		private String email;
		private String endereço;
		
		
		@ManyToOne
		@JoinColumn(name = "id_turma")
		private Turma turma;
		
		
		@ManyToMany
		@JoinTable(name ="matricula",joinColumns = {@JoinColumn(name="id_aluno")},inverseJoinColumns = {@JoinColumn(name="id_disciplina")})
		private List<Disciplina> disciplinas;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Turma getTurma() {
			return turma;
		}
		public void setTurma(Turma turma) {
			this.turma = turma;
		}
		public List<Disciplina> getDisciplinas() {
			return disciplinas;
		}
		public void setDisciplinas(List<Disciplina> disciplinas) {
			this.disciplinas = disciplinas;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEndereço() {
			return endereço;
		}
		public void setEndereço(String endereço) {
			this.endereço = endereço;
		}
		
		
		
		
		
		
		
		
}
