package br.com.cursopreparatorio.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;






@Entity
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomedadisciplina;
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomedadisciplina() {
		return nomedadisciplina;
	}
	public void setNomedadisciplina(String nomedadisciplina) {
		this.nomedadisciplina = nomedadisciplina;
	}
	
	





}
