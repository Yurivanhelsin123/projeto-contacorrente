package com.contacorrente.fourbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity



public class Cliente {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idcliente;
	
	
	
	@NotBlank(message="Por favor ,preencha o campo obrigatório")
	private String clientenome;	
	
	private String clientecpf;
	
	  @NotNull
	  @NotEmpty(message="Por favor,preencha o campo obrigatório")
	private String clientefone;
	
	@ManyToOne
	@JoinColumn(name = "idagencia_agencia")
	private Agencia agencia;

    @OneToOne	
	@JoinColumn(name = "idcontacorrente_contacorrente")
	private ContaCorrente contacorrente;
	
	
	
	
	
	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	public String getClientenome() {
		return clientenome;
	}
	public void setClientenome(String clientenome) {
		this.clientenome = clientenome;
	}
	public String getClientecpf() {
		return clientecpf;
	}
	public void setClientecpf(String clientecpf) {		
		
		this.clientecpf = clientecpf;
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getClientefone() {
		return clientefone;
	}
	public void setClientefone(String clientefone) {
		
		
		
		
		
		
		this.clientefone = clientefone;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public ContaCorrente getContacorrente() {
		return contacorrente;
	}
	public void setContacorrente(ContaCorrente contacorrente) {
		this.contacorrente = contacorrente;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
