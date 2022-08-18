package com.contacorrente.fourbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contacorrente.fourbank.entity.ContaCorrente;
import com.contacorrente.fourbank.entity.Extrato;

@Repository
@Transactional(readOnly = false)
public interface ExtratoRepository extends JpaRepository<Extrato, Integer>{
	
	
	List<Extrato> findByContacorrente(ContaCorrente contacorrente);
	
	
	
	
	

}
