package com.contacorrente.fourbank.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ContaCorrente {

@Id	
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer idcontacorrente;
private Integer numerodaconta;
private Integer numerodaagencia;
private Double	saldocontacorrente;


@JsonIgnore
@OneToMany(mappedBy = "contacorrente")
private List<Extrato> extratos;



public Integer getIdcontacorrente() {
	return idcontacorrente;
}
public void setIdcontacorrente(Integer idcontacorrente) {
	this.idcontacorrente = idcontacorrente;
}
public Integer getNumerodaagencia() {
	return numerodaagencia;
}
public void setNumerodaagencia(Integer numerodaagencia) {
	this.numerodaagencia = numerodaagencia;
}
public Integer getNumerodaconta() {
	return numerodaconta;
}
public void setNumerodaconta(Integer numerodaconta) {
	this.numerodaconta = numerodaconta;
}
public Double getSaldocontacorrente() {
	return saldocontacorrente;
}
public void setSaldocontacorrente(Double saldocontacorrente) {
	this.saldocontacorrente = saldocontacorrente;
}





public List<Extrato> getExtratos() {
	return extratos;
}
public void setExtratos(List<Extrato> extratos) {
	this.extratos = extratos;
}




	
	
	
	
	
	
	
	
	
	
	
	
}
