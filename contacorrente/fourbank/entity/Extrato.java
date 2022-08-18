package com.contacorrente.fourbank.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;




@Entity
public class Extrato {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private  Integer idextrato;
private  LocalDateTime   datahoramovimento=LocalDateTime.now();
private	 String  operacao;
private Double  valoroperacao;


@ManyToOne()

private ContaCorrente contacorrente;


public Integer getIdextrato() {
	return idextrato;
}
public void setIdextrato(Integer idextrato) {
	this.idextrato = idextrato;
}
public LocalDateTime getDatahoramovimento() {
	return datahoramovimento;
}
public void setDatahoramovimento(LocalDateTime datahoramovimento) {
	this.datahoramovimento = datahoramovimento;
}
public String getOperacao() {
	return operacao;
}
public void setOperacao(String operacao) {
	this.operacao = operacao;
}
public Double getValoroperacao() {
	return valoroperacao;
}
public void setValoroperacao(Double valoroperacao) {
	this.valoroperacao = valoroperacao;
}
public ContaCorrente getContacorrente() {
	return contacorrente;
}
public void setContacorrente(ContaCorrente contacorrente) {
	this.contacorrente = contacorrente;
}
















	
}









