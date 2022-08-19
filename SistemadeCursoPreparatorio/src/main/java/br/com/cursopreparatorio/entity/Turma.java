package br.com.cursopreparatorio.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Turma {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomedaturma;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomedaturma() {
		return nomedaturma;
	}
	public void setNomedaturma(String nomedaturma) {
		this.nomedaturma = nomedaturma;
	}









}
