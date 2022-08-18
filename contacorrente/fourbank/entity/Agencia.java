package com.contacorrente.fourbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Agencia {

@Id 
@GeneratedValue(strategy=GenerationType.AUTO) 
private Integer	idagencia ;

private Integer numerobanco;

private Integer numeroagencia;

private String 	nomeagencia ;
@NotBlank
private String endereco;
@NotEmpty
private String	telefone;












public Integer getIdagencia() {
	return idagencia;
}
public void setIdagencia(Integer idagencia) {
	this.idagencia = idagencia;
}
public String getNomeagencia() {
	return nomeagencia;
}
public void setNomeagencia(String nomeagencia) {
	this.nomeagencia = nomeagencia;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public Integer getNumeroagencia() {
	return numeroagencia;
}
public void setNumeroagencia(Integer numeroagencia) {
	this.numeroagencia = numeroagencia;
}
public Integer getNumerobanco() {
	return numerobanco;
}
public void setNumerobanco(Integer numerobanco) {
	this.numerobanco = numerobanco;
}






	
	
	
	
	
	
	
			
			
			
}
