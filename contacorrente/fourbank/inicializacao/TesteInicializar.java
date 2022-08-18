package com.contacorrente.fourbank.inicializacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.contacorrente.fourbank.entity.Agencia;
import com.contacorrente.fourbank.entity.Cliente;
import com.contacorrente.fourbank.entity.ContaCorrente;
import com.contacorrente.fourbank.entity.Extrato;

import com.contacorrente.fourbank.service.AgenciaService;
import com.contacorrente.fourbank.service.ClienteService;
import com.contacorrente.fourbank.service.ContaCorrenteService;
import com.contacorrente.fourbank.service.ExtratoService;

@Component
public class TesteInicializar implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	ClienteService clienteservice;
	@Autowired
	AgenciaService agenciaservice;
	@Autowired
	ContaCorrenteService contacorrenteservice;
	@Autowired
	ExtratoService extratoservice;

	public void onApplicationEvent(ContextRefreshedEvent event) {

		Cliente cliente1 = new Cliente();
		cliente1.setClientenome("Jean claude Vandaime");
		cliente1.setClientecpf("102.453.234-67");
		cliente1.setClientefone("(21)98857-3467");

		Cliente cliente2 = new Cliente();
		cliente2.setClientenome("Rafael de Catro Souza");
		cliente2.setClientecpf("106.223.204-87");
		cliente2.setClientefone("(21)95455-3337");

		Cliente cliente3 = new Cliente();
		cliente3.setClientenome("Rayane Silva");
		cliente3.setClientecpf("111.553.222-60");
		cliente3.setClientefone("(21)92257-0067");

		Cliente cliente4 = new Cliente();
		cliente4.setClientenome("Yuri Yokada");
		cliente4.setClientecpf("102.453.234-67");
		cliente4.setClientefone("(21)98857-3467");

		Cliente cliente5 = new Cliente();
		cliente5.setClientenome("Miriam Martins");
		cliente5.setClientecpf("107.222.291-12");
		cliente5.setClientefone("(21)78887-3447");
		
		
		
		Cliente cliente6 = new Cliente();
		cliente6.setClientenome("Raimunda Souza");
		cliente6.setClientecpf("108.124.647-41");		
		cliente6.setClientefone("(21)78487-3447");
		
		
		ContaCorrente conta1 = new ContaCorrente();
		conta1.setNumerodaagencia(948);
		conta1.setNumerodaconta(98832 - 8);
		conta1.setSaldocontacorrente(0.0);

		ContaCorrente conta2 = new ContaCorrente();
		conta2.setNumerodaagencia(948);
		conta2.setNumerodaconta(97732 - 8);
		conta2.setSaldocontacorrente(0.0);

		ContaCorrente conta3 = new ContaCorrente();
		conta3.setNumerodaagencia(948);
		conta3.setNumerodaconta(99532 - 8);
		conta3.setSaldocontacorrente(0.0);

		ContaCorrente conta4 = new ContaCorrente();
		conta4.setNumerodaagencia(948);
		conta4.setNumerodaconta(96632 - 8);
		conta4.setSaldocontacorrente(0.0);

		ContaCorrente conta5 = new ContaCorrente();
		conta5.setNumerodaagencia(948);
		conta5.setNumerodaconta(97432 - 8);
		conta5.setSaldocontacorrente(0.0);
		
		
		
		contacorrenteservice.salvar(conta1);
		contacorrenteservice.salvar(conta2);
		contacorrenteservice.salvar(conta3);
		contacorrenteservice.salvar(conta4);
		contacorrenteservice.salvar(conta5);

		
		
		Extrato extrato1 = new Extrato();
		extrato1.setOperacao("saque");
		extrato1.setValoroperacao(0.0);	

		Extrato extrato2 = new Extrato();		
		extrato2.setOperacao("deposito");
		extrato2.setValoroperacao(0.0);
		
		Extrato extrato3 = new Extrato();
		extrato3.setOperacao("saque");
		extrato3.setValoroperacao(0.0);
		
		Extrato extrato4 = new Extrato();
		extrato4.setOperacao("transferencia");
		extrato4.setValoroperacao(0.0);
		
		Extrato extrato5 = new Extrato();
		extrato5.setOperacao("deposito");
		extrato5.setValoroperacao(0.0);
		
		extrato1.setContacorrente(conta1);
		extrato2.setContacorrente(conta2);
		extrato3.setContacorrente(conta5);
		extrato4.setContacorrente(conta5);		
		extrato5.setContacorrente(conta5);
		
		extratoservice.salvar(extrato1);
		extratoservice.salvar(extrato2);
		extratoservice.salvar(extrato3);
		extratoservice.salvar(extrato4);
		extratoservice.salvar(extrato5);
		
		
		
		

		
		Agencia agencia = new Agencia();
		agencia.setNumeroagencia(948);
		agencia.setNomeagencia("FourBank ");
		agencia.setEndereco("Av das Américas 1005 ,Barra da Tijuca ,Rio de Janeiro - cep:21667-2000");
		agencia.setNumerobanco(1234);
		agencia.setTelefone("(21)99000-1000");
	
		agenciaservice.salvar(agencia);
		
		

		cliente1.setAgencia(agencia);
		cliente2.setAgencia(agencia);
		cliente3.setAgencia(agencia);
		cliente4.setAgencia(agencia);
		cliente5.setAgencia(agencia);
		
		
		
		
		
		
		cliente1.setContacorrente(conta1);
		cliente2.setContacorrente(conta2);
		cliente3.setContacorrente(conta3);
		cliente4.setContacorrente(conta4);
		cliente5.setContacorrente(conta5);
		
		
		
		
		
		clienteservice.salvar(cliente1);
		clienteservice.salvar(cliente2);
		clienteservice.salvar(cliente3);
		clienteservice.salvar(cliente4);
		clienteservice.salvar(cliente5);
		clienteservice.salvar(cliente6);
		
			
		
	
		
		
		
		
		
		
		
	}

}
